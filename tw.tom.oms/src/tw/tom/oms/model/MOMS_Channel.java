package tw.tom.oms.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MOMS_Channel extends X_oms_channel {

	private static final long serialVersionUID = 1L;

	public MOMS_Channel(Properties ctx, int oms_channel_ID, String trxName, String... virtualColumns) {
		super(ctx, oms_channel_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Channel(Properties ctx, int oms_channel_ID, String trxName) {
		super(ctx, oms_channel_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Channel(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Channel(Properties ctx, String oms_channel_UU, String trxName, String... virtualColumns) {
		super(ctx, oms_channel_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Channel(Properties ctx, String oms_channel_UU, String trxName) {
		super(ctx, oms_channel_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
