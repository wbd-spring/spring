package com.spring.aop.aspect;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.spring.service.Waiter;
import com.spring.service.impl.NavieWaiter;

public class TestAsceptJProxy {

	public static void main(String[] args) {
		
		Waiter w = new NavieWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		//设置目标对象
		factory.setTarget(w);
		//设置切面类
		factory.addAspect(PreGreetingAspect.class);
		
		//生成织入切面的代理对象
		Waiter proxy= factory.getProxy();
		
		proxy.greetTo("张三");
		
		proxy.serverTo("李四");
		
		System.out.println(proxy);

	
	}

}
