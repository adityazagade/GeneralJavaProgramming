package aop.service;

import org.springframework.aop.ThrowsAdvice;

public class BankServiceErrors implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("Some Exception Occurred");
    }

}
