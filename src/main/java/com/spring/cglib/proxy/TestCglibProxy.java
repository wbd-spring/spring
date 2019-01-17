package com.spring.cglib.proxy;

import com.spring.service.ForumServiceImpl;

public class TestCglibProxy {

	public static void main(String[] args) {
		
		CglibProxy proxy = new CglibProxy();
		
		ForumServiceImpl fs = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
		
		fs.addTopic(500);
		fs.removeTopic(120);
	}

}
