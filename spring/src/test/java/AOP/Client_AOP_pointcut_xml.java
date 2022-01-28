package AOP;

import aop.Account;
import aop.AccountNotFoundException;
import aop.Bank;
import aop.pointcut.BankDepositPointCut;
import aop.service.BankLoggerService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class Client_AOP_pointcut_xml {
    // There are two point cut advisors
    // 1. DefaultPointCutAdvisors
    // 2. RegularExpressionMethodPointCutAdvisor
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop/spring_aop_advisors.xml");
        Bank sbiProxy = (Bank) context.getBean("bankProxy");
        sbiProxy.deposit("SBIN001", 500);
        try {
            int balance = sbiProxy.getBalance("SBIN001");
            System.out.println("Balance: " + balance);
        } catch (AccountNotFoundException e) {
            //consume error ..
        }
    }
}
