# Architecture

The OMS plugin is designed with a layered architecture to separate platform definitions from channel-specific execution.

```mermaid
graph TD
  A[oms_platform] --> B[oms_channel]
  B --> C[Sync Job]
  C --> D[Factory Implementation]
  D --> E[C_Order Generation]
  E --> F[Logistics Callback]

  subgraph External Platforms
    G[Cyberbiz]
    H[Shopee]
    I[Momo]
  end

  A --> G
  A --> H
  A --> I
```

Components
oms_platform: Platform metadata (API keys, host, name)

oms_channel: Represents one actual online store account

Sync Job: Pulls data from channels periodically or on-demand

Factory: Implements platform-specific APIs

C_Order: The iDempiere standard order document
