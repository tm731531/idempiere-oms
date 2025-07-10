# Configuration Guide

This guide describes how to configure platforms and channels in the iDempiere OMS Plugin.

---

## 🔧 1. Configure Platforms (`oms_platform`)

Platforms represent third-party e-commerce systems such as Cyberbiz, Shopee, or Shopline.

| Field         | Description                                |
|---------------|--------------------------------------------|
| Name          | Display name of the platform               |
| Host          | Base URL of the API                        |
| Key / Secret  | API authentication credentials             |
| Description   | Optional text to describe the platform     |

> ⚠️ Note: Some platforms like Shopee or Facebook require OAuth-based tokens. Future versions may support token flow.

Example:
Name: Cyberbiz
Host: https://api.cyberbiz.io
Key: xxxxxx
Secret: yyyyyy
---

## 🏪 2. Configure Channels (`oms_channel`)

Channels represent specific store accounts under a platform. You can link multiple channels to the same platform.

| Field              | Description                                 |
|--------------------|---------------------------------------------|
| Name               | Store or Channel name                       |
| Platform           | Linked `oms_platform` record                |
| Access Token       | Optional (OAuth or token-based APIs)        |
| Shop ID / Account  | Optional ID used in some APIs               |
| Description        | Optional description                        |
| Active             | Indicates if the channel is active          |

Example:
Name: Cyberbiz Store TW
Platform: Cyberbiz
Access Token: (empty for now)
Account ID: shop_tw
---

## 📘 Field Notes

- `Access Token` is optional and used only if the API requires token-based access
- `Host` in `oms_platform` should **not** end with a slash `/`
- You can script additional validation logic using Callout or Process

---

## ✅ Checklist

Before executing any Process:

- [x] At least one `oms_platform` is configured
- [x] Each `oms_channel` is correctly linked to a platform
- [x] API credentials are filled in
- [x] Channels are marked as **Active**

---

## ⏭ Coming Soon

- API key rotation tracking
- Multi-store JSON mapping

