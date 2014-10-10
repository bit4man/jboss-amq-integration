package com.github.ligangty.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.ejb3.annotation.ResourceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(name = "MyMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSBridgeTargetQ"), //Note to use physical queue name
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
@ResourceAdapter("activemq-rar.rar")  // needed to specify, point to activemq resource-adaptor id
public class TestMDB implements MessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(TestMDB.class); 

    public void onMessage(Message message) {
        try {

            final TextMessage textMessage = (TextMessage) message;
            LOG.debug(textMessage.getText());

        } catch (JMSException e) {
            throw new IllegalStateException(e);
        }
    }

}
