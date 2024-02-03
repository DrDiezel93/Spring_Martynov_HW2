package com.example.HW_Sem2.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Log
public class LoggingAspect {
    @Around("@annotation(com.example.HW_Sem2.aspect.TrackUserAction)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info("Method " + "'" + joinPoint.getSignature().getName() +"'"+ " executed in " + executionTime + "ms");

        return proceed;
    }
}
