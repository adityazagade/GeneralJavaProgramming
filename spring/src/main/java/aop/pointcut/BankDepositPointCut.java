package aop.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class BankDepositPointCut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        if (method.getName().equals("deposit")) {
            return true;
        }
        return false;
    }
}
