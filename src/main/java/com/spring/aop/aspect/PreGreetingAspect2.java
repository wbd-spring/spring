package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 定义一个切面
 * @author jwh
 *
 */
@Aspect
public class PreGreetingAspect2 {
    //前置通知
	//@Before("execution(public * com.spring.service.impl..*(..))")//方法前面定义切点
	//@Before("execution(public * com.spring.service.impl.AnnotationWaiter2.*(..))")//类定义切点
	//@Before("execution(* com.spring.service..*(..))")//类包定义切点
	//@Before("within(com.spring.service.impl.*)")//within 只能定义到类的所有方法，不能定义到指定的方法
	//他是粗粒度的，只能定义到类与子类，而execution可以定义到类， 包， 方法。
	@Before("target(com.spring.service.Waiter)") //target 目标类是否匹配指定类来决定连接点是否匹配
	//this与target是等价的，所以不做演示。
	public void beforeGreeting() { //横切面逻辑
		
		System.out.println("你好...");
		
		
	}
	
	
}
