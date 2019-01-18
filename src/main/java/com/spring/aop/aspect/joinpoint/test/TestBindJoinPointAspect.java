package com.spring.aop.aspect.joinpoint.test;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.spring.aop.aspect.joinpoint.AccessJoinPointInfomationAscept;
import com.spring.service.impl.AnnotationWaiter;
import com.spring.service.impl.AnnotationWaiter2;

public class TestBindJoinPointAspect {

	public static void main(String[] args) {
		
		AnnotationWaiter w = new AnnotationWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		//设置目标对象
		factory.setTarget(w);
		//设置切面类
		factory.addAspect(AccessJoinPointInfomationAscept.class);
		
		//生成织入切面的代理对象
		AnnotationWaiter proxy= factory.getProxy();
		
		proxy.greetTo("张三");
		
		proxy.serverTo("李四");
		
		System.out.println(proxy);

	
	}

}
