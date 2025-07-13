# Architecture

## OrderGetJob = OMSGetOrderProcess.java

The OMS plugin is designed with a layered architecture to separate platform definitions from channel-specific execution.



```mermaid
flowchart TD
    Platform["OMS_Platform<br/>(Shopee, Cyberbiz, Shopline)"]
    Channel["OMS_Channel<br/>(Store 1, Store 2, etc.)"]
    Scheduler["Scheduler Process"]
    Factory["OrderServiceFactory"]
    Service["ShopeeOrderService / CyberbizOrderService"]
    DTO["UnifiedOrderDTO"]
    MOrder["MOrder (iDempiere Core Order)"]

    Platform --> Channel
    Channel --> Scheduler
    Scheduler --> Factory
    Factory --> Service
    Service --> DTO
    DTO --> MOrder
```

Components
oms_platform: Platform metadata (API keys, host, name)

oms_channel: Represents one actual online store account

Scheduler: Pulls data from channels periodically or on-demand

Factory: Implements platform-specific APIs

MOrder: The iDempiere standard order document


## RefreshTokenJob = OMSRefreshTokenProcess.java

This job is implemented as `OMSRefreshTokenProcess`, a process registered in the iDempiere Scheduler.  
It accepts `MOMS_Channel_ID` as input and calls the platform-specific refresh logic.

```mermaid
flowchart TD
    A[Scheduler triggers OMSRefreshTokenProcess] --> B[Get MOMS_Channel_ID from parameter]
    B --> C[Load MOMS_Channel from DB]
    C --> D{Which platform?}

    D -->|CyberbizV2| E[Call refreshToken]
    D -->|Shopee| F[Call refreshToken]
    D -->|Others| G[Skip or throw error]

    E --> H[Update access_token in DB]
    F --> H
```
