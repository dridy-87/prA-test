package com.miris.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.miris.test.util.LoggerColor;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MeasureTimeAspect {
	
	@Around("execution(* com.miris..*(..)) && @annotation(com.miris.test.aop.annotation.MeasureTime)")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        stopWatch.stop();

        log.info(
                LoggerColor.yellowBackground("- - - - - - 실행시간 {}(): {} ms"),
                joinPoint.getSignature().getName(),
                stopWatch.getTotalTimeMillis()
        );

        return result;
    }
}
