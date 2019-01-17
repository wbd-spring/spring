package com.spring.service.impl;

import com.spring.annotation.NeedTest;
import com.spring.service.Waiter;

public class AnnotationWaiter2  implements Waiter{

	@NeedTest
	public void greetTo(String clientName) {
		System.out.println("CGLib代理" + clientName);
	}

	public void serverTo(String clientName) {
		System.out.println("为你服务" + clientName);
	}

}
