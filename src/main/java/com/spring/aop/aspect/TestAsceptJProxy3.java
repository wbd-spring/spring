package com.spring.aop.aspect;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.spring.service.impl.AnnotationWaiter2;

public class TestAsceptJProxy3 {

	public static void main(String[] args) {
		
		AnnotationWaiter2 w = new AnnotationWaiter2();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		//设置目标对象
		factory.setTarget(w);
		//设置切面类
		factory.addAspect(PreGreetingAspect2.class);
		
		//生成织入切面的代理对象
		AnnotationWaiter2 proxy= factory.getProxy();
		
		proxy.greetTo("张三");
		
		proxy.serverTo("李四");
		
		System.out.println(proxy);

	
	}

}
