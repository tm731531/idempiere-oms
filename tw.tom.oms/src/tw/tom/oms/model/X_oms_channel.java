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
/** Generated Model - DO NOT CHANGE */
package tw.tom.oms.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for oms_channel
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="oms_channel")
public class X_oms_channel extends PO implements I_oms_channel, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250703L;

    /** Standard Constructor */
    public X_oms_channel (Properties ctx, int oms_channel_ID, String trxName)
    {
      super (ctx, oms_channel_ID, trxName);
      /** if (oms_channel_ID == 0)
        {
			setName (null);
			setoms_channel_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_oms_channel (Properties ctx, int oms_channel_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, oms_channel_ID, trxName, virtualColumns);
      /** if (oms_channel_ID == 0)
        {
			setName (null);
			setoms_channel_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_oms_channel (Properties ctx, String oms_channel_UU, String trxName)
    {
      super (ctx, oms_channel_UU, trxName);
      /** if (oms_channel_UU == null)
        {
			setName (null);
			setoms_channel_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_oms_channel (Properties ctx, String oms_channel_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, oms_channel_UU, trxName, virtualColumns);
      /** if (oms_channel_UU == null)
        {
			setName (null);
			setoms_channel_ID (0);
        } */
    }

    /** Load Constructor */
    public X_oms_channel (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_oms_channel[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set channel_sn.
		@param channel_sn channel_sn
	*/
	public void setchannel_sn (String channel_sn)
	{
		set_Value (COLUMNNAME_channel_sn, channel_sn);
	}

	/** Get channel_sn.
		@return channel_sn	  */
	public String getchannel_sn()
	{
		return (String)get_Value(COLUMNNAME_channel_sn);
	}

	/** Set oms_channel.
		@param oms_channel_ID oms_channel
	*/
	public void setoms_channel_ID (int oms_channel_ID)
	{
		if (oms_channel_ID < 1)
			set_ValueNoCheck (COLUMNNAME_oms_channel_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_oms_channel_ID, Integer.valueOf(oms_channel_ID));
	}

	/** Get oms_channel.
		@return oms_channel	  */
	public int getoms_channel_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_oms_channel_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set oms_channel_UU.
		@param oms_channel_UU oms_channel_UU
	*/
	public void setoms_channel_UU (String oms_channel_UU)
	{
		set_Value (COLUMNNAME_oms_channel_UU, oms_channel_UU);
	}

	/** Get oms_channel_UU.
		@return oms_channel_UU	  */
	public String getoms_channel_UU()
	{
		return (String)get_Value(COLUMNNAME_oms_channel_UU);
	}

	public I_oms_platform getoms_platform() throws RuntimeException
	{
		return (I_oms_platform)MTable.get(getCtx(), I_oms_platform.Table_ID)
			.getPO(getoms_platform_ID(), get_TrxName());
	}

	/** Set oms_platform.
		@param oms_platform_ID oms_platform
	*/
	public void setoms_platform_ID (int oms_platform_ID)
	{
		if (oms_platform_ID < 1)
			set_ValueNoCheck (COLUMNNAME_oms_platform_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_oms_platform_ID, Integer.valueOf(oms_platform_ID));
	}

	/** Get oms_platform.
		@return oms_platform	  */
	public int getoms_platform_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_oms_platform_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set token1.
		@param token1 token1
	*/
	public void settoken1 (String token1)
	{
		set_Value (COLUMNNAME_token1, token1);
	}

	/** Get token1.
		@return token1	  */
	public String gettoken1()
	{
		return (String)get_Value(COLUMNNAME_token1);
	}

	/** Set token2.
		@param token2 token2
	*/
	public void settoken2 (String token2)
	{
		set_Value (COLUMNNAME_token2, token2);
	}

	/** Get token2.
		@return token2	  */
	public String gettoken2()
	{
		return (String)get_Value(COLUMNNAME_token2);
	}

	/** Set token4.
		@param token4 token4
	*/
	public void settoken4 (String token4)
	{
		set_Value (COLUMNNAME_token4, token4);
	}

	/** Get token4.
		@return token4	  */
	public String gettoken4()
	{
		return (String)get_Value(COLUMNNAME_token4);
	}

	/** Set token5.
		@param token5 token5
	*/
	public void settoken5 (String token5)
	{
		set_Value (COLUMNNAME_token5, token5);
	}

	/** Get token5.
		@return token5	  */
	public String gettoken5()
	{
		return (String)get_Value(COLUMNNAME_token5);
	}

	@Override
	public void settoken3(String token3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String gettoken3() {
		// TODO Auto-generated method stub
		return null;
	}
}