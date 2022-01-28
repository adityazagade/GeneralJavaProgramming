package spring;

import org.springframework.jms.core.JmsTemplate;
public class SpringMessageProducer {
    private JmsTemplate jmsTemplate;


    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(final String message) {
        jmsTemplate.send(session -> session.createTextMessage(message));
    }

}
