package com.github.ligangty.jms;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Singleton
public class TestMessageProducer {
    private static final Logger LOG = LoggerFactory.getLogger(TestMessageProducer.class);
    @Resource(name = "java:/AMQConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name = "java:/queue/JMSBridgeTargetQ") // Note the name of the queue is jndi name  
    private Queue answerQueue;

    public void sendMessage(String message) throws Exception {

        final Connection connection = connectionFactory.createConnection();

        connection.start();

        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        final MessageProducer sender = session.createProducer(answerQueue);
        sendText(message, sender, session);

        session.close();
        connection.close();
    }

    private void sendText(String text, MessageProducer sender, Session session) throws JMSException {

        sender.send(session.createTextMessage(text));
    }

    private String receiveText(MessageConsumer answers) throws JMSException {

        return ((TextMessage) answers.receive(1000)).getText();
    }
}
