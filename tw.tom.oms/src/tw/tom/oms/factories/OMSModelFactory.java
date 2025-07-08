package tw.tom.oms.factories;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

import tw.tom.oms.model.MOMS_Channel;
import tw.tom.oms.model.MOMS_Platform;

public class OMSModelFactory implements IModelFactory {


	@Override
	public Class<?> getClass(String tableName) {
		if(tableName.equals(MOMS_Channel.Table_Name))
			return MOMS_Channel.class;
		if(tableName.equals(MOMS_Platform.Table_Name))
			return MOMS_Platform.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if(tableName.equals(MOMS_Channel.Table_Name))
			return new MOMS_Channel(Env.getCtx(),Record_ID,trxName);
		if(tableName.equals(MOMS_Platform.Table_Name))
			return new MOMS_Platform(Env.getCtx(),Record_ID,trxName);
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if(tableName.equals(MOMS_Channel.Table_Name))
			return new MOMS_Channel(Env.getCtx(),rs,trxName);
		if(tableName.equals(MOMS_Platform.Table_Name))
			return new MOMS_Platform(Env.getCtx(),rs,trxName);
		return null;
	}

}
