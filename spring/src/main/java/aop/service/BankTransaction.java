package aop.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.AspectJAroundAdvice;

public class BankTransaction implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //before
        System.out.println("Method Interceptor before");
        Object o = methodInvocation.proceed();
        //after
        System.out.println("Method Interceptor After");
        return o;
    }
}
