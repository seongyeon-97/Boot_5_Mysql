package com.sy.b5.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	//@Before("execution(* com.sy.b5.aop.transfer.Transfer.*(..))")
	//@AfterReturning("execution(* com.sy.b5.aop.transfer.Transfer.*(..))")
	@Around("execution(* com.sy.b5.aop.transfer.Transfer.*(..))")
	public Object cardChesk(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("---- 타기전 Card Check -----");
		Object obj = joinPoint.proceed(); // 핵심 로직 실행
		System.out.println("---- 내릴때 Card Check -----");
		
		return obj;
	}
}
