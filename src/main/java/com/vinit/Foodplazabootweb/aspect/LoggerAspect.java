package com.vinit.Foodplazabootweb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@ConditionalOnExpression("${aop.loggerAdvice.enable}")
public class LoggerAspect {

	@Before("CSRExpression()")
	public void logMethodDetailsBeforeAdvice(JoinPoint jp) {

		log.info("START: {}, with args: {}", jp.getSignature(), jp.getArgs());
	}

	@AfterThrowing(pointcut = "CSRExpression()", throwing = "ex")
	public void logMethodDetailsAfterThrowingAdvice(JoinPoint jp, Object ex) {

		log.info("END: {}, with exception: {}", jp.getSignature(), ex);
	}

	@AfterReturning(pointcut = "CSRExpression()", returning = "returnValue")
	public void logMethodDetailsAfterReturningAdvice(JoinPoint jp, Object returnValue) {

		log.info("END: {}, with return value: {}", jp.getSignature(), returnValue);
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
