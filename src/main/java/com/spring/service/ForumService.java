package com.spring.service;

/**
 * 目标对象的接口
 * 论坛业务类接口
 * @author jwh
 *
 */
public interface ForumService {

	
	//删除
	public void removeTopic(int topicId); 
	
	
	//添加论坛
	
	public void addTopic(int topicId);
}
