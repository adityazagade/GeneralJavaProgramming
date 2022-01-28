package spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SpringMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("MAGIC HAPPENED!");
        if (message instanceof TextMessage) {
            String text = null;
            try {
                text = ((TextMessage) message).getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            System.out.println(text);
        }
    }
}
