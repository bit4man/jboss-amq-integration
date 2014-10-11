Jboss AS 7 ActiveMQ integration example
============

This is an example project to show how to integrate Jboss AS7 and Active MQ together

Preparation
============

This need activemq resource adaptor to do further work. do as following:

1. copy config/jbossas/modules/org/apache/activemq/main/* to ${JBOSS_HOME}/modules/org/apache/activemq/main/
2. use config/jbossas/standalone/configuration/standalone-full-jbossaq.xml to start your jboss as (eap)
3. try TestMDB and TestMessageProducer