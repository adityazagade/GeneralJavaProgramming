package AOP;

import aop.AccountNotFoundException;
import aop.Bank;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_AOP_programmatic_xml {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop/spring_aop.xml");
        Bank sbiProxy = (Bank) context.getBean("bankProxy");
        sbiProxy.deposit("SBIN001", 500);
        sbiProxy.deposit("SBIN002", 1500);
        sbiProxy.deposit("SBIN003", 5000);

        sbiProxy.deposit("SBIN001", 5000);
        try {
            int balance = sbiProxy.getBalance("SBIN001");
            System.out.println("Balance: " + balance);
        } catch (AccountNotFoundException e) {
            //consume error ..
        }
    }
}
