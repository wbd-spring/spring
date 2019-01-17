package com.spring.service;

//目标对象
public class ForumServiceImpl implements ForumService {

	public void removeTopic(int topicId) {
		
		System.out.println("模拟删除topic记录"+topicId);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addTopic(int topicId) {
		System.out.println("模拟添加topic记录..."+topicId);
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
