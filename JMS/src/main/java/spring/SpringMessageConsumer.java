package spring;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;

public class SpringMessageConsumer {
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public String receiveMessage() {
        Message m = jmsTemplate.receive();
        try {
            return (String) new SimpleMessageConverter().fromMessage(m);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
}
