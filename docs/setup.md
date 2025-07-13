# 📦 OMS Plugin Installation & Setup Guide

This document describes how to install and initialize the iDempiere OMS plugin, including process registration, table setup, API credentials configuration, and scheduler creation.  

---

## 1️⃣ Register the OMS Processes in iDempiere
Go to *System Admin → Report & Process* and register the following processes:
| Process Name            | Java Class Name                                  | Description                        |
|-------------------------|--------------------------------------------------|------------------------------------|
| Get Order Process       | `tw.tom.oms.process.OMSGetOrderProcess`          | Fetch orders and create `MOrder`  |
| Refresh Token Process   | `tw.tom.oms.process.OMSRefreshTokenProcess`      | Refresh API tokens for platforms  |

---

## 2️⃣ Import Custom Tables: `oms_platform` and `oms_channel`
Use 2pack with OMS_X.X.X.zip 

---

## 3️⃣ Configure API Settings for Platforms and Channels

In iDempiere, go to the `OMS_Platform` and `OMS_Channel` forms and enter the required data.

### OMS_Platform:
- Platform name
- API base host (e.g., `https://api.shopee.com`)
- Client ID, Client Secret (if applicable)

### OMS_Channel:
- Linked Platform
- Access Token, Refresh Token, Expiry Time
- Channel Name, Sync Start Date, Default Warehouse

---

## 4️⃣ Initialize Master Data: Products, Warehouse, Business Partners

To ensure orders are processed correctly, set up the following:

- **Product**: Ensure SKUs match those used by the platform (barcode, value, etc.)
- **Warehouse**: At least one warehouse must exist, or map one as default
- **Business Partner**: OMS will auto-create BPartners if needed, but addresses may be required

---

## 5️⃣ Create Scheduler Entries

Set up two scheduled tasks under *System Admin → Schedule Process*:

| Scheduler Name        | Process Class                | Suggested Frequency     |
|------------------------|-------------------------------|--------------------------|
| OMS Order Sync         | `OMSGetOrderProcess`          | Every 5 minutes          |
| Token Refresh Scheduler| `OMSRefreshTokenProcess`      | Every 4 hours            |


---

## 6️⃣ Test the Setup

To verify the plugin is working correctly:

1. Manually run `OMSGetOrderProcess`
2. Check system logs or console output for errors
3. Verify that orders are created in `MOrder`
4. Run `OMSRefreshTokenProcess` and confirm token fields update properly
---

## 7️⃣ Common Errors & Troubleshooting
> 7️⃣ 常見錯誤與排除方式

| Error Message                        | Possible Cause                            | Suggested Fix                                  |
|-------------------------------------|-------------------------------------------|------------------------------------------------|
| `BPartner has no address`           | Address missing for new buyer             | Add address manually or handle in code         |
| `Platform not recognized`           | Platform name mismatch in factory         | Check platform name in channel config          |
| No orders fetched / DTO is null     | API returned empty or mapping failed      | Inspect API call result and mapping logic      |

---

## 📎 Related Documents
> 📎 相關文檔

- [`developer.md`](./developer.md): Plugin architecture & extension guide  
- [`introduction.md`](./introduction.md): System overview  

---

