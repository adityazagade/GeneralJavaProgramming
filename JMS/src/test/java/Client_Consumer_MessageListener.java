import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Client_Consumer_MessageListener {
    public static void main(String[] args) {
        try {
            test();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws JMSException {
        ConnectionFactory cf = new ActiveMQConnectionFactory(SharedConstants.URL1);
        Connection con = cf.createConnection();
        con.start();
        Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue q = session.createQueue(SharedConstants.QUEUE_NAME);
        MessageConsumer cons = session.createConsumer(q);
        cons.setMessageListener(new SimpleMessageListener());
    }

}
