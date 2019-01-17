package com.spring.annotation;

//目标对象
public class ForumServiceImpl  {

	@NeedTest(true)
	public void removeTopic(int topicId) {
		
		System.out.println("模拟删除注解"+topicId);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@NeedTest(false)
	public void addTopic(int topicId) {
		System.out.println("模拟添加注解..."+topicId);
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
