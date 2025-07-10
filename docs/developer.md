# Developer Guide

## Adapter Pattern

Each platform should implement its own adapter class, for example:

```java
public interface IOMSAdapter {
    List<OrderDTO> fetchOrders(OMS_Channel channel);
}
```

## Adding a New Platform
Implement adapter class for new platform

Register it via factory:

```
OMSAdapterFactory.register("shopee", new ShopeeAdapter());
```

## Extending Process
Create a custom Process class in iDempiere

Use oms_channel_id as context variable

Call the appropriate adapter and convert into C_Order

## Plugin Build
Use Maven to compile a deployable OSGi JAR.

```bash!
mvn clean install

```