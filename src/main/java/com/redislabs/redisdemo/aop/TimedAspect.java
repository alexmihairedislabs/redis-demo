package com.redislabs.redisdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimedAspect {

    private static final Logger log = LoggerFactory.getLogger(TimedAspect.class);

    @Around("@annotation(Timed)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }

    @Around("within(org.springframework.data.redis..*)")
    public Object logExecutionTimeInDriver(ProceedingJoinPoint joinPoint) throws Throwable {
        return this.logExecutionTime(joinPoint);
    }
}
