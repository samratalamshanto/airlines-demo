package com.samarat.airlinesdemoproject.config.logger;

import com.samarat.airlinesdemoproject.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

    @Around("within(com.samarat.airlinesdemoproject.service..*)")
    public Object log(final @NotNull ProceedingJoinPoint joinPoint) throws Throwable {
        final String methodName = joinPoint.getSignature().getName();
        final String className = joinPoint.getTarget().getClass().getSimpleName();
        final Object[] args = joinPoint.getArgs();

        if (args.length > 0) {
            log.info("Invoked.. {}::{}() and args={}", className, methodName, Utility.objectToJsonString(args));
        } else {
            log.info("Invoked.. {}::{}()", className, methodName);
        }
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeMillis = System.currentTimeMillis() - start;
        log.info("Complete[{}ms].. {}::{}() and Result={}", timeMillis, className, methodName, Utility.objectToJsonString(result));
        return result;
    }
}
