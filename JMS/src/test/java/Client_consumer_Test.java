import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Client_consumer_Test {
    public static void main(String[] args) {
        try {
            // to check whther which of consumer.close(), session.close(), connection.close() actually closes the consumer.
            // consumer.close() closes that individual consumer.
            // session.close() will close all the consumer in that session();
            // connection.close() will close all the consumer in that connection.
            test();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws JMSException {
        ConnectionFactory cf = new ActiveMQConnectionFactory(SharedConstants.URL1);
        Connection con = cf.createConnection();
        con.start();
        Session session = con.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue q = session.createQueue(SharedConstants.QUEUE_NAME);
        MessageConsumer cons = session.createConsumer(q);
//        MessageConsumer cons1 = session.createConsumer(q);
//        MessageConsumer cons2 = session.createConsumer(q);
//        MessageConsumer cons3 = session.createConsumer(q);

        Message m = cons.receive();
        if (m instanceof TextMessage) {
            String t = ((TextMessage) m).getText();
            System.out.println(t);
        }
//        cons.close();
//        session.close();
        con.close();
    }
}
