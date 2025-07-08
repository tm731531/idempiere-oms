package tw.tom.oms.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MOMS_Platform extends X_oms_platform {

	private static final long serialVersionUID = 1L;

	public MOMS_Platform(Properties ctx, int oms_platform_ID, String trxName, String... virtualColumns) {
		super(ctx, oms_platform_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Platform(Properties ctx, int oms_platform_ID, String trxName) {
		super(ctx, oms_platform_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Platform(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Platform(Properties ctx, String oms_platform_UU, String trxName, String... virtualColumns) {
		super(ctx, oms_platform_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MOMS_Platform(Properties ctx, String oms_platform_UU, String trxName) {
		super(ctx, oms_platform_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
