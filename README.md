Jboss AS 7 ActiveMQ integration example
============

This is an example project to show how to integrate Jboss AS7 and Active MQ together

Preparation
============

This need activemq resource adaptor to do further work. After build, you can find the activemq-rar-5.10.0.rar in org/apache/activemq/activemq-rar/5.10.0/ in your local maven repository, copy it to your jboss as 7 modules folder and do as following:

1. extract this rar file to modules/org/apache/activemq/main/
2. create module.xml modules/org/apache/activemq/main/ and add following contents
```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.0" name="org.apache.activemq">
  <resources>
    <resource-root path="."/>
    <resource-root path="activemq-broker-5.10.0.jar"/>
    <resource-root path="activemq-client-5.10.0.jar"/>
    <resource-root path="activemq-jms-pool-5.10.0.jar"/>
    <resource-root path="activemq-kahadb-store-5.10.0.jar"/>
    <resource-root path="activemq-openwire-legacy-5.10.0.jar"/>
    <resource-root path="activemq-pool-5.10.0.jar"/>
    <resource-root path="activemq-protobuf-1.1.jar"/>
    <resource-root path="activemq-ra-5.10.0.jar"/>
    <resource-root path="activemq-spring-5.10.0.jar"/>
    <resource-root path="aopalliance-1.0.jar"/>
    <resource-root path="commons-logging-1.1.3.jar"/>
    <resource-root path="commons-net-3.3.jar"/>
    <resource-root path="commons-pool-1.6.jar"/>
    <resource-root path="hawtbuf-1.10.jar"/>
    <!--resource-root path="geronimo-j2ee-management_1.1_spec-1.0.1.jar"/-->
    <resource-root path="spring-aop-3.2.8.RELEASE.jar"/>
    <resource-root path="spring-beans-3.2.8.RELEASE.jar"/>
    <resource-root path="spring-context-3.2.8.RELEASE.jar"/>
    <resource-root path="spring-core-3.2.8.RELEASE.jar"/>
    <resource-root path="spring-expression-3.2.8.RELEASE.jar"/>
    <resource-root path="xbean-spring-3.16.jar"/>
  </resources>
  <exports>
    <exclude path="org/springframework/**"/>
    <exclude path="org/apache/xbean/**"/>
    <exclude path="org/apache/commons/**"/>
    <exclude path="org/aopalliance/**"/>
    <exclude path="org/fusesource/**"/>
  </exports>
  <dependencies>
    <module name="javax.api"/>
    <module name="org.slf4j"/>
    <module name="javax.resource.api"/>
    <module name="javax.jms.api"/>
    <module name="javax.management.j2ee.api"/>
  </dependencies>
</module>
```

3. use config/standalone-full-jbossaq.xml to start your jboss as (eap)
4. try TestMDB and TestMessageProducer