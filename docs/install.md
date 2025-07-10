# Installation Guide

## Prerequisites

- iDempiere 9.0+ recommended
- Admin access to System Dictionary
- Optional: Plugin jar deployment capability

## Step-by-Step (System Dictionary Method)

1. Go to `System Administrator`
2. Open System > Data > Import Metadata
3. Import `PackOut.xml` from `dict/` folder
4. Logout → Login again
5. You will see new menus: OMS Platform, OMS Channel

## Plugin Deployment (Optional)

If a compiled plugin jar is provided:

1. Place the jar in `idempiere-server/plugins/`
2. Restart the server
3. Verify OSGi console shows plugin loaded