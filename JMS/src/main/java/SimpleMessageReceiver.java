import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class SimpleMessageReceiver {
    private String queueName;
    private ConnectionFactory cf;

    public SimpleMessageReceiver(String queueName, String url) {
        this.queueName = queueName;
        cf = new ActiveMQConnectionFactory(url);
    }

    public String receiveMessage() {
        Connection con = null;
        try {
            con = cf.createConnection();
            con.start();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);

            //This session.createConsumer(queue); will create consumer which will be shown on ACTIVEMQ CONSOLE AS ACTIVE CONSUMER.
            MessageConsumer consumer = session.createConsumer(queue);


            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                return ((TextMessage) message).getText();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void receiveMessageWithSameSession() throws InterruptedException {
        Connection con = null;
        try {
            con = cf.createConnection();
            con.start();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueName);
            MessageConsumer consumer = session.createConsumer(queue);

            for (int i = 0; i < 200; i++) {
                Message message = consumer.receive();
                if (message instanceof TextMessage) {
                    System.out.println(((TextMessage) message).getText());
                }
                Thread.sleep(2000);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
