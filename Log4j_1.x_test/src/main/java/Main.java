import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) throws NamingException {
//        Hashtable env = new Hashtable<String, String>();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//        env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=jnditutorial");
//        env.put(Context.SECURITY_PRINCIPAL, "ou=admin");
//        env.put(Context.SECURITY_CREDENTIALS, "Admin@123");
//        Context ctx = new InitialContext(env);

        Logger logger = Logger.getLogger("com.foo");
        logger.debug("Hi there");

        

    }
}
