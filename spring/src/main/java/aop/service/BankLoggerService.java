package aop.service;

import aop.Bank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BankLoggerService implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Log logger = LogFactory.getLog(Bank.class);
        logger.info(method.getName() + " " + objects.toString() + " " + o.toString());
        System.out.println("Before Bank Method Call");
    }
}
