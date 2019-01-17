package com.spring.jdk.dynamic.proxy;

import java.lang.reflect.Proxy;

import com.spring.service.ForumService;
import com.spring.service.ForumServiceImpl;

public class TestJDKProxy {

	public static void main(String[] args) {
		
		//希望被代理的目标业务类
		ForumService  target = new ForumServiceImpl();
		
		//将目标业务类和横切面代码编织在一起
		JdkDynamicProxy jdp = new JdkDynamicProxy(target);
		
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), jdp);

		proxy.addTopic(100);
	}

}
