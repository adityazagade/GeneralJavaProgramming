import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class SimpleMessageProducer {

    private String queueName;
    private ConnectionFactory cf;

    public SimpleMessageProducer(String queueName, String url) {
        this.queueName = queueName;
//        cf = new ActiveMQConnectionFactory(SharedConstants.USERNAME, SharedConstants.PASSWORD, SharedConstants.URL);
        cf = new ActiveMQConnectionFactory(url);
    }

    public void sendMessage(String message) {
        try {
            // Create a Connection
            Connection con = cf.createConnection();
            con.start();
            // Create a Session
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue q = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(q);
            TextMessage text = session.createTextMessage(message);
            producer.send(text);
            con.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageWithSameSession(String message) throws InterruptedException {
        try {
            // Create a Connection
            Connection con = cf.createConnection();
            con.start();
            // Create a Session
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue q = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(q);
            TextMessage text = session.createTextMessage(message);
            for (int i = 0; i < 200; i++) {
                Thread.sleep(1000);
                producer.send(text);
            }
            con.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
