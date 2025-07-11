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


Example:
<pre>
Name: Cyberbiz
Host: https://api.cyberbiz.io
Key: xxxxxx
Secret: yyyyyy
</pre>
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
<pre>
Example:
Name: Cyberbiz Store TW
Platform: Cyberbiz
Access Token: 
Account ID(channel_sn): xxxxx.cyberbiz.co

</pre>
https://wiki.idempiere.org/en/Oms-idempiere#Token_sample

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
- other platform

| platform           | status                                 |
|--------------------|----------------------------------------|
| cyberbizV1| OK |
| cyberbizV2| OK |
| shopline | working |
| shopify | planing |
| shopee | planing |
| momo | planing |
| yahoo mall | planing |

