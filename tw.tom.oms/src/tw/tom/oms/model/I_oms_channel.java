/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package tw.tom.oms.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for oms_channel
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
@SuppressWarnings("all")
public interface I_oms_channel 
{

    /** TableName=oms_channel */
    public static final String Table_Name = "oms_channel";

    /** AD_Table_ID=1000005 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name channel_sn */
    public static final String COLUMNNAME_channel_sn = "channel_sn";

	/** Set channel_sn	  */
	public void setchannel_sn (String channel_sn);

	/** Get channel_sn	  */
	public String getchannel_sn();

    /** Column name oms_channel_ID */
    public static final String COLUMNNAME_oms_channel_ID = "oms_channel_ID";

	/** Set oms_channel	  */
	public void setoms_channel_ID (int oms_channel_ID);

	/** Get oms_channel	  */
	public int getoms_channel_ID();

    /** Column name oms_channel_UU */
    public static final String COLUMNNAME_oms_channel_UU = "oms_channel_UU";

	/** Set oms_channel_UU	  */
	public void setoms_channel_UU (String oms_channel_UU);

	/** Get oms_channel_UU	  */
	public String getoms_channel_UU();

    /** Column name oms_platform_ID */
    public static final String COLUMNNAME_oms_platform_ID = "oms_platform_ID";

	/** Set oms_platform	  */
	public void setoms_platform_ID (int oms_platform_ID);

	/** Get oms_platform	  */
	public int getoms_platform_ID();

	public I_oms_platform getoms_platform() throws RuntimeException;

    /** Column name token1 */
    public static final String COLUMNNAME_token1 = "token1";

	/** Set token1	  */
	public void settoken1 (String token1);

	/** Get token1	  */
	public String gettoken1();

    /** Column name token2 */
    public static final String COLUMNNAME_token2 = "token2";

	/** Set token2	  */
	public void settoken2 (String token2);

	/** Get token2	  */
	public String gettoken2();

    /** Column name token2 */
    public static final String COLUMNNAME_token3 = "token3";

	/** Set token2	  */
	public void settoken3 (String token3);

	/** Get token2	  */
	public String gettoken3();

    /** Column name token4 */
    public static final String COLUMNNAME_token4 = "token4";

	/** Set token4	  */
	public void settoken4 (String token4);

	/** Get token4	  */
	public String gettoken4();

    /** Column name token5 */
    public static final String COLUMNNAME_token5 = "token5";

	/** Set token5	  */
	public void settoken5 (String token5);

	/** Get token5	  */
	public String gettoken5();
}
