package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
public class MethodInvokeCountMetricAspect {

    private Map<String,Long> methodInvokeCount=new java.util.HashMap<>();

    @Before(value = "execution(@com.example.annotation.Count * *(..))")
    public void doCount(
            JoinPoint joinPoint
    ){
       String methodName=joinPoint.getSignature().getName();
       methodInvokeCount.put(methodName,methodInvokeCount.getOrDefault(methodName,0L)+1);
       System.out.println(methodInvokeCount);
    }

}
