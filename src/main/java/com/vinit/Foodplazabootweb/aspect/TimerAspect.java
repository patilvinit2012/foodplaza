package com.vinit.Foodplazabootweb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@ConditionalOnExpression("${aop.timerAdvice.enable}")
public class TimerAspect {

	@Around("CSRExpression()")
	public Object timerAdvice(ProceedingJoinPoint pjp) throws Throwable {

		Object returnValue = null;
		long total = 0;
		try {

			long start = System.currentTimeMillis();
			returnValue = pjp.proceed();
			long end = System.currentTimeMillis();
			total = end - start;
			log.info("{}:- Execution Time: {} ms", pjp.getSignature(), total);

		} catch (Throwable e) {
			log.error("Error while execution: {}", pjp.getSignature());
			throw e;
		}
		return returnValue;
	}

	@Pointcut("@within(org.springframework.stereotype.Component)")
	private void componentExpression() {
	}

	@Pointcut("@within(org.springframework.stereotype.Service)")
	private void serviceExpression() {
	}

	@Pointcut("@within(org.springframework.stereotype.Repository)")
	private void repositoryExpression() {
	}

	@Pointcut("@within(org.springframework.stereotype.Controller)")
	private void controllerExpression() {
	}

	@Pointcut("controllerExpression() || serviceExpression() || repositoryExpression()")
	private void CSRExpression() {
	}
}
