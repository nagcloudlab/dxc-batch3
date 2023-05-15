package com.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class ExceptionCountMetricAspect {

    private Map<String,Long> exceptionCountMap=new java.util.HashMap<>();

    @AfterThrowing(value = "execution(@com.example.annotation.Count * *(..))",throwing = "e")
    public void doExceptionCount(
            JoinPoint joinPoint,
            Throwable e
    )throws Throwable {
        String methodName=joinPoint.getSignature().getName();
        exceptionCountMap.put(e.getClass().getName(),exceptionCountMap.getOrDefault(methodName,0L)+1);
        System.out.println(exceptionCountMap);
        throw  e;
    }

}
