



# iDempiere OMS Plugin

> **iDempiere OMS** is a plugin designed to integrate the iDempiere ERP system with external e-commerce platforms such as Cyberbiz, Shopee, Shopline, and others. It serves as a central order management layer to automate order fetching, platform-channel mapping, and logistics updates.

---

## Features

- Multi-platform support: Cyberbiz, Shopee, Shopline, Momo, etc.
- Channel-based design: Each platform can manage multiple store accounts
- Built fully using iDempiere Dictionary and plugin extension
- Supports Scheduler, Process, and Workflow integration
- Includes API configuration support: key, secret, host, etc.

---

## Database Tables

| Table         | Description                                                |
|---------------|------------------------------------------------------------|
| `oms_platform` | Master table for defining platform information (API host, key, etc.) |
| `oms_channel`  | Defines each actual store/account under a platform         |

Example:
<pre> ```text oms_platform 
  └── Cyberbiz, Shopee, Momo... 
  
  oms_channel 
  ├── Shopee-Store A (linked to Shopee) 
  ├── Shopee-Store B 
  └── Cyberbiz-TW Main Store ``` </pre>
oms_platform
└── Cyberbiz, Shopee, Momo...

oms_channel
├── Shopee-Store A (linked to Shopee)
├── Shopee-Store B
└── Cyberbiz-TW Main Store


Hence, we designed a separate `oms_channel` table to handle these variations.
https://wiki.idempiere.org/en/Oms-idempiere#Token_sample
----

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

