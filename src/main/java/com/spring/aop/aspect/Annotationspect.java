package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 自定义的注解
 * 定义一个切面
 * @author jwh
 *
 */
@Aspect
public class Annotationspect {
    //前置通知  自定义的注解
	@Before("@annotation(com.spring.annotation.NeedTest)")
	public void needTest() { //横切面逻辑
		
		System.out.println("@annotation...");
		
		
	}
	
	
}
