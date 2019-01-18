package com.spring.aop.aspect.joinpoint.test;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.spring.aop.aspect.joinpoint.AccessJoinPointInfomationAscept;
import com.spring.aop.aspect.joinpoint.BindJoinPointAscept;
import com.spring.service.impl.AnnotationWaiter;
import com.spring.service.impl.AnnotationWaiter2;
import com.spring.service.impl.TargetWaiter;

public class TestAsceptJoinPoint {

	public static void main(String[] args) {
		
		TargetWaiter w = new TargetWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		//设置目标对象
		factory.setTarget(w);
		//设置切面类
		factory.addAspect(BindJoinPointAscept.class);
		
		//生成织入切面的代理对象
		TargetWaiter proxy= factory.getProxy();
		
//		proxy.greetTo("张三",1);
//		
//		proxy.serverTo("李四",4);
		
	//	proxy.testNeed();
		
		proxy.sum(2, 5);
	
	}

}
