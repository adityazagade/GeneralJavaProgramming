package temp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class TestJMSConnection {

    public static void main(String[] args) throws IOException {
        JMXServiceURL url =
                new JMXServiceURL(args[0]);
        Map<String, Object> env = new HashMap<>();
        JMXConnector jmxConnector = null;
        if (args.length > 1) {
            env.put(JMXConnector.CREDENTIALS, new String[]{args[1], args[2]});
            jmxConnector = JMXConnectorFactory.connect(url, env);
        } else {
            jmxConnector = JMXConnectorFactory.connect(url);
        }
        MBeanServerConnection mbeanServerConnection = jmxConnector.getMBeanServerConnection();
        System.out.println("Connection successful");
        jmxConnector.close();
    }
}
