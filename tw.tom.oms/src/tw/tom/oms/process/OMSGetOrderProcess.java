package tw.tom.oms.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.I_AD_CtxHelpMsg;
import org.compiere.model.MBPartner;
import org.compiere.model.MCtxHelpMsg;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;

import com.google.gson.*;

import tw.tom.oms.DTO.*;
import tw.tom.oms.interfaces.*;
import tw.tom.oms.model.*;
import tw.tom.oms.service.*;

public class OMSGetOrderProcess extends SvrProcess {

	/** Shipment */
//	private ParameterDto parameters = new ParameterDto();
	private String oms_channel_ID;
	private CyberbizOrderService cbs = new CyberbizOrderService();

	/**
	 * Prepare - e.g., get Parameters.
	 */
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			System.out.println("name :" + name);
			if (name.equals("oms_channel_ID")) {
				System.out.println("value :" + para[i].getParameterAsString());
				oms_channel_ID = para[i].getParameterAsString();
			}
		}
	} // prepare

	protected String doIt() throws Exception {

		int AD_Client_ID = Env.getAD_Client_ID(getCtx());// 11
		int AD_Org_ID = Env.getAD_Org_ID(getCtx());
		MOMS_Channel channelData = getChannelData();
		if (channelData == null) {
			throw new IllegalArgumentException("Channel not found for ID: " + oms_channel_ID);
		}

		List<UnifiedOrderDTO> orders = fetchOrders(channelData);
		for (UnifiedOrderDTO order : orders) {
			if (isOrderExists(order.order_number, 50001)) {
				log.info("訂單已存在，跳過 DocumentNo=" + order.order_number);
				continue;
			}
			createOrderFromUnifiedOrderDTO(order, AD_Org_ID);
		}

		return "Done";
	}

	private MOMS_Channel getChannelData() {
		Query query = new Query(Env.getCtx(), MOMS_Channel.Table_Name, "oms_channel_ID=?", get_TrxName());
		return query.setParameters(Integer.valueOf(oms_channel_ID)).first();
	}

	private List<UnifiedOrderDTO> fetchOrders(MOMS_Channel channelData) throws Exception {
		String platformName = channelData.getoms_platform().getName();

		IOrderService service = OrderServiceFactory.getService(platformName);
		List<UnifiedOrderDTO> orders = service.fetchOrders(channelData);

		return orders;
	}

	private int getBPartnerLocationID(int bpartnerID) {
		String sql = "SELECT C_BPartner_Location_ID FROM C_BPartner_Location WHERE C_BPartner_ID=? AND IsActive='Y' ORDER BY IsBillTo DESC";
		return DB.getSQLValueEx(get_TrxName(), sql, bpartnerID);
	}

	private boolean isOrderExists(String documentNo, int bpartnerId) {
		String sql = "SELECT COUNT(*) FROM C_Order WHERE DocumentNo = ? AND C_BPartner_ID = ? AND IsActive='Y'";
		int count = DB.getSQLValue(get_TrxName(), sql, documentNo, bpartnerId);
		return count > 0;
	}

	private void createOrderFromUnifiedOrderDTO(UnifiedOrderDTO orderData, int AD_Org_ID) {
		MOrder order = new MOrder(getCtx(), 0, get_TrxName());
		order.setAD_Org_ID(AD_Org_ID);
		order.setC_DocTypeTarget_ID(MOrder.DocSubTypeSO_Standard);
		order.setDeliveryRule(MOrder.DELIVERYRULE_CompleteOrder);
		order.setDocStatus(DocAction.STATUS_Drafted);
		order.setDocAction(DocAction.ACTION_Complete);
		Timestamp today = TimeUtil.getDay(System.currentTimeMillis());
		order.setDatePromised(today);
		order.setDocumentNo(String.valueOf(orderData.order_number));
		order.setDescription("fromCyberbiz");
		order.setC_BPartner_ID(50001);
//		order.setBPartner(MBPartner.get(getCtx(), 50001));
		order.setM_Warehouse_ID(103);

		order.setBill_BPartner_ID(50001); // optional，通常一起設

		int bpartnerLocationID = getBPartnerLocationID(50001);
		if (bpartnerLocationID <= 0) {
			throw new AdempiereException("BPartner 沒有任何地址，請先建立至少一筆地址");
		}
		order.setC_BPartner_Location_ID(bpartnerLocationID);
		order.saveEx();

		// 遍历并创建订单行
		for (var lineItem : orderData.line_items) {
			MOrderLine orderLine = new MOrderLine(getCtx(), 0, get_TrxName());
			orderLine.setAD_Org_ID(order.getAD_Org_ID());
			orderLine.setC_Order_ID(order.getC_Order_ID());
			int M_Product_ID = getProductIdBySKU(lineItem.sku);
			if (M_Product_ID <= 0) {
				if (lineItem.sku == null || lineItem.sku.trim().isEmpty()) {
					log.warning("無SKU：" + lineItem.sku + "，此明细将略過");
					continue;
				}
				MProduct product = new MProduct(getCtx(), 0, get_TrxName());
				product.setValue(lineItem.sku);
				product.setName(lineItem.title); // ← 請從 API 中取得名稱
				product.setC_TaxCategory_ID(107);
				product.setM_Product_Category_ID(50000);
				product.setC_UOM_ID(200001);
				product.setProductType(MProduct.PRODUCTTYPE_Item);
				product.setIsStocked(false); // ✅ 無限數量
				product.setIsSold(true);
				product.setIsPurchased(false);
				product.saveEx();
				// log.warning("找不到商品 SKU：" + lineItem.sku + "，此明细将略过");
				// continue;
				M_Product_ID = product.getM_Product_ID();
			}
			orderLine.setM_Product_ID(M_Product_ID, true);
			orderLine.setQty(new BigDecimal(lineItem.quantity));
			orderLine.setPrice(new BigDecimal(lineItem.price));
			orderLine.setDescription(lineItem.title);
			orderLine.setM_Warehouse_ID(order.getM_Warehouse_ID());
			orderLine.saveEx();
		}
	}

	private int getDocTypeTargetID(String docBaseType) {
		String sql = "SELECT C_DocType_ID FROM C_DocType WHERE DocBaseType = ? AND IsSOTrx='Y' AND IsActive='Y' AND AD_Client_ID=?";
		return DB.getSQLValueEx(get_TrxName(), sql, docBaseType, Env.getAD_Client_ID(getCtx()));
	}

	private int getProductIdBySKU(String sku) {
		if (sku == null || sku.trim().isEmpty())
			return -1;

		String sql = "SELECT M_Product_ID FROM M_Product WHERE Value = ?";
		return DB.getSQLValueEx(null, sql, sku);
	}

}
