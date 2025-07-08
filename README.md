## `oms_platform`

Setting name at first .
If the platform follows a third-party integration design, you should configure the **ID**, **Key**, and **Host** in this table.
Note: **Login** and **Redirect URL** are **not provided** in this case.

---

## `oms_channel`

A single platform can support multiple sales channels.
For example:

* Cyberbiz 1
* Shopee 1
* Shopee 2
* Cyberbiz 2
* Shopline 1
* Momo 1

Hence, we designed a separate `oms_channel` table to handle these variations.

---

## Reports and Processes (for system admin)

1. `OMSGetOrderProcess` – Responsible for fetching order data using the appropriate worker.
2. `OMSRefreshTokenProcess` – Handles refreshing of access tokens for each channel.

---

## Scheduler (configured by Tanet account)

1. Configure platform-level data.
2. Configure channel-level data.
3. Register relevant processes with the scheduler.

   * If the platform requires token refresh, be sure to include `OMSRefreshTokenProcess`.

---

## Platform Notes

Some platforms follow a third-party integration design. In such cases, the platform **must be configured with the corresponding app information first** (App ID, Key, Host, etc.).
