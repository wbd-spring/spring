package com.spring.service.impl;

import com.spring.annotation.NeedTest;

public class TargetWaiter  {

	public void greetTo(String clientName,int num) {
		System.out.println("欢迎光临" + clientName+"num="+num);
	}

	public void serverTo(String clientName,int num) {
		System.out.println("为你服务" + clientName+"num="+num);
	}
	
	@NeedTest(true)
	public void testNeed() {
		System.out.println("testNeed*********");
	}
	
	
	public int sum(int i,int j) {
		return i+j;
	}

}
