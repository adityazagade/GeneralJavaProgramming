import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.net.JMSAppender;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main2 {
    public static void main(String[] args) throws NamingException {
        Properties env = new Properties( );
        env.put("java.naming.security.principal", "ou=admin");
        env.put("java.naming.security.credentials", "Admin@123456");
        InitialContext jndiContext = new InitialContext(env);

        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);

        JMSAppender j = new JMSAppender();
        j.setInitialContextFactoryName("org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        j.setProviderURL("tcp://localhost:61616");
        j.setUserName("system");
        j.setPassword("manager");
        j.setSecurityCredentials("Admin@123");
        j.setSecurityPrincipalName("ou=admin");
        j.setTopicBindingName("ldap://localhost:389/ou=People,dc=axeda,dc=com");
        j.setTopicConnectionFactoryBindingName("ConnectionFactory");
        j.activateOptions();

        Logger logger = Logger.getLogger("com.foo");
        logger.addAppender(j);

        logger.debug("Aditya_zagade_topic_message");
    }
}
