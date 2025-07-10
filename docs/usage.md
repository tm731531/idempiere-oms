# Usage Guide

## Configure a Platform

1. Go to `OMS Platform`
2. Add a platform (e.g., Cyberbiz) with:
   - Name
   - Host
   - Key / Secret

## Add a Channel

1. Go to `OMS Channel`
2. Create a channel entry for the store account
3. Link it to the appropriate platform
4. Configure any extra store-specific parameters

## Trigger a Sync Process

1. Select the channel
2. Run the associated process (to be implemented):
   - Fetch Orders
   - Sync Products
3. Orders should appear in standard `Sales Orders`

## Check Logs

- View Process Log in `Process Monitor`
- Logs for API responses can also be written to custom fields
