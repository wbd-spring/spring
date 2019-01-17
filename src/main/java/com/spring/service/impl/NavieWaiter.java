package com.spring.service.impl;

import com.spring.service.Waiter;

public class NavieWaiter implements Waiter {

	public void greetTo(String clientName) {
		System.out.println("欢迎光临" + clientName);
	}

	public void serverTo(String clientName) {
		System.out.println("为你服务" + clientName);
	}

}
