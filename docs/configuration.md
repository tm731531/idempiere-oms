# Configuration Guide

This guide describes how to configure platforms and channels in the iDempiere OMS Plugin.

---

## 🔧 1. Configure Platforms (`oms_platform`)

Platforms represent third-party e-commerce systems such as Cyberbiz, Shopee, or Shopline.

| Field         | Description                                |
|---------------|--------------------------------------------|
| Name          | Display name of the platform               |
| Host          | Base URL of the API Host(some api usage is diff with host api dns,like refresh token , target is platform)                        |
| Key / ID  | API authentication credentials             |
| Description   | Optional text to describe the platform     |


Example:
<pre>
Name: Cyberbiz
Host: https://api.cyberbiz.io
ID: xxxxxx
Key: yyyyyy
</pre>
---

## 🏪 2. Configure Channels (`oms_channel`)

### Platform and Token Mapping

The `oms_platform` field determines which platform this channel belongs to and drives the factory logic for processing.

Each platform may have different requirements for tokens stored in the generic `token_1`, `token_2`, `token_3` fields.  
For example, some platforms use:

- `token_1`: Access Token  
- `token_2`: Refresh Token  
- `token_3`: Token Expiry or other credentials

Additionally, some platforms require extra fields like `channel_sn` (channel serial number) for authentication or API calls.

**It is essential to consult the platform-specific documentation to understand the exact usage of these fields.**

https://wiki.idempiere.org/en/Oms-idempiere#Token_sample

### Example Token and Field Usage per Platform

| Platform    | `token1`       | `token2`       | `token3`       | `channel_sn`     |
|-------------|-----------------|-----------------|-----------------|-------------------|
| Shopee      | Access Token    | Refresh Token   | (not used)      | Shop id           |
| Cyberbiz V2 |  Access Token    |Refresh Token   | (not used)      | Shop DNS           |
| Shopline    | API Key         | API Secret      | Token Expiry    | (none)            |



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

