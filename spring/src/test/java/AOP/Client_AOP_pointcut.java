package AOP;

import aop.Account;
import aop.AccountNotFoundException;
import aop.Bank;
import aop.pointcut.BankDepositPointCut;
import aop.service.BankLoggerService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.util.ArrayList;

public class Client_AOP_pointcut {
    // There are two point cut advisors
    // 1. DefaultPointCutAdvisors
    // 2. RegularExpressionMethodPointCutAdvisor
    public static void main(String[] args) {
        BankDepositPointCut pc = new BankDepositPointCut();
        BankLoggerService advice = new BankLoggerService();
        DefaultPointcutAdvisor ad = new DefaultPointcutAdvisor();
        ad.setPointcut(pc);
        ad.setAdvice(advice);

        //Create Bank Object
        Bank sbi = new Bank("SBI");
        Account a1 = new Account("SBIN001");
        Account a2 = new Account("SBIN002");
        Account a3 = new Account("SBIN003");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        sbi.setAccounts(accounts);


        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setTarget(sbi);
        pfb.addAdvisor(ad);

        Bank sbiProxy = (Bank) pfb.getObject();
        sbiProxy.deposit("SBIN001", 500);
        try {
            int balance = sbiProxy.getBalance("SBIN001");
            System.out.println("Balance: " + balance);
        } catch (AccountNotFoundException e) {
            //consume error ..
        }
    }
}
