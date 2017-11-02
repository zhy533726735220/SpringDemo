package com.zhy.service.proxy;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ServiceProxy {
    @Before("execution(* com.zhy.service..*.*(..))")
    public void beforeInvoke() {
        System.out.println("ServiceProxy-before在业务方法执行之前进行调用");
    }

    @After(value = "execution(* com.zhy.service..*.*(..)) && args(obj)", argNames = "obj")
    public void afterInvoke(Object obj) {
        System.out.println("ServiceProxy-after在业务方法执行之后进行调用" + obj);
    }

    public void throwInvoke(Exception e) {
        System.out.println("ServiceProxy-Exception抛出异常：" + e);
    }

    @AfterReturning(value = "execution(* com.zhy.service..*.*(..))", returning = "val", argNames = "val")
    public void returnInvoke(Object val) {
        System.out.println("ServiceProxy-return返回值=" + val);
    }

    // 环绕代理：如果要进行后续调用需要知道传递的参数，需要知道具体要调用的业务方法
    @Around("execution(* com.zhy.service..*.*(..))")
    public Object aroundInvoke(ProceedingJoinPoint point) throws Throwable {
        System.out.println("【*** BEFORE ***】执行参数：" + Arrays.toString(point.getArgs()));
        // Object obj = point.proceed(point.getArgs()) ;正常操作要将用户的参数继续向后传递
        Object obj = point.proceed(new Object[] {"mldnjava"} ) ;	// 自己来处理参数内容
        System.out.println("【*** AFTER ***】返回结果：" + obj);
        return true ;
    }
}
