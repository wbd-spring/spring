package com.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 定义一个切面
 * @author jwh
 *
 */
@Aspect
public class PreGreetingAspect {
    //前置通知
	@Before("execution(* com.spring.service.impl.NavieWaiter.*(..))")
	public void beforeGreeting() { //横切面逻辑
		
		System.out.println("你好...");
		
		
	}
	
	 //前置通知
		@After("execution(* com.spring.service.impl.NavieWaiter.*(..))")
		public void afterGreeting( ) { //横切面逻辑
			
			System.out.println("byte...");
			
			
		}
}
