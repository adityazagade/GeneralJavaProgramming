package AOP;

import aop.Account;
import aop.AccountNotFoundException;
import aop.Bank;
import aop.service.BankLoggerService;
import aop.service.BankPostProcess;
import aop.service.BankServiceErrors;
import aop.service.BankTransaction;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.util.ArrayList;

public class Client_AOP_Programmatic {
    public static void main(String[] args) {
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

        //Create Service


        //Combine Services and Target with Proxy
        // This will make the advice to run before each method call in bank. We want to run it on specific methods only ...
        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setTarget(sbi);
        pfb.addAdvice(new BankLoggerService());
        pfb.addAdvice(new BankPostProcess());
        pfb.addAdvice(new BankServiceErrors());
        pfb.addAdvice(new BankTransaction());

        // directly calling it on sbi will have no effect
//        sbi.deposit("SBIN001", 500);
//        sbi.deposit("SBIN002", 1500);
//        sbi.deposit("SBIN003", 5000);
//
//        sbi.deposit("SBIN001", 5000);
//        try {
//            int balance = sbi.getBalance("SBIN001");
//            System.out.println("Balance: " + balance);
//        } catch (AccountNotFoundException e) {
//            //consume error ..
//        }


        Bank sbiProxy = (Bank) pfb.getObject();
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
