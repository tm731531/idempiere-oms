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

/** Generated Model for oms_platform
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="oms_platform")
public class X_oms_platform extends PO implements I_oms_platform, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250703L;

    /** Standard Constructor */
    public X_oms_platform (Properties ctx, int oms_platform_ID, String trxName)
    {
      super (ctx, oms_platform_ID, trxName);
      /** if (oms_platform_ID == 0)
        {
			setName (null);
			setoms_platform_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_oms_platform (Properties ctx, int oms_platform_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, oms_platform_ID, trxName, virtualColumns);
      /** if (oms_platform_ID == 0)
        {
			setName (null);
			setoms_platform_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_oms_platform (Properties ctx, String oms_platform_UU, String trxName)
    {
      super (ctx, oms_platform_UU, trxName);
      /** if (oms_platform_UU == null)
        {
			setName (null);
			setoms_platform_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_oms_platform (Properties ctx, String oms_platform_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, oms_platform_UU, trxName, virtualColumns);
      /** if (oms_platform_UU == null)
        {
			setName (null);
			setoms_platform_ID (0);
        } */
    }

    /** Load Constructor */
    public X_oms_platform (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_oms_platform[")
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

	/** Set oms_platform_UU.
		@param oms_platform_UU oms_platform_UU
	*/
	public void setoms_platform_UU (String oms_platform_UU)
	{
		set_Value (COLUMNNAME_oms_platform_UU, oms_platform_UU);
	}

	/** Get oms_platform_UU.
		@return oms_platform_UU	  */
	public String getoms_platform_UU()
	{
		return (String)get_Value(COLUMNNAME_oms_platform_UU);
	}

	/** Set platform_host.
		@param platform_host platform_host
	*/
	public void setplatform_host (String platform_host)
	{
		set_Value (COLUMNNAME_platform_host, platform_host);
	}

	/** Get platform_host.
		@return platform_host	  */
	public String getplatform_host()
	{
		return (String)get_Value(COLUMNNAME_platform_host);
	}

	/** Set platform_id.
		@param platform_id platform_id
	*/
	public void setplatform_id (String platform_id)
	{
		set_Value (COLUMNNAME_platform_id, platform_id);
	}

	/** Get platform_id.
		@return platform_id	  */
	public String getplatform_id()
	{
		return (String)get_Value(COLUMNNAME_platform_id);
	}

	/** Set platform_key.
		@param platform_key platform_key
	*/
	public void setplatform_key (String platform_key)
	{
		set_Value (COLUMNNAME_platform_key, platform_key);
	}

	/** Get platform_key.
		@return platform_key	  */
	public String getplatform_key()
	{
		return (String)get_Value(COLUMNNAME_platform_key);
	}
}