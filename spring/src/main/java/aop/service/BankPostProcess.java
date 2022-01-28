package aop.service;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class BankPostProcess implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Bank After Method");
    }
}
