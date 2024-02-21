package com.example.HW_Sem2.aspect;

import com.example.HW_Sem2.service.FileGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Log
public class LoggingAspect {
    private final FileGateway fileGateway;

    @Around("@annotation(com.example.HW_Sem2.aspect.TrackUserAction)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info("Method " + "'" + joinPoint.getSignature().getName() +"'"+ " executed in " + executionTime + "ms");
        fileGateway.writeToFile("log.txt", ("Method " + "'" + joinPoint.getSignature().getName() +"'"+ " executed in " + executionTime + "ms"));
        return proceed;
    }
}
