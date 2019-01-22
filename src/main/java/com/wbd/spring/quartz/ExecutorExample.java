package com.wbd.spring.quartz;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Executor执行器，为java.util.concurrent(并发) 包中核心接口，
 * 将任务提交和任务执行分离， 实现降低耦合
 * @author jwh
 *
 */
public class ExecutorExample {
	
	private Executor executor;
	
	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
	
	public void executeTask() {
		for(int i=0;i<100;i++) {
			executor.execute(new SimpleTask("任务"+i));
		}
	}
	
	public static void main(String[] args) {
		
		ExecutorExample  ee = new ExecutorExample();
		ee.setExecutor(Executors.newFixedThreadPool(4));
		ee.executeTask();
	}
	
	class SimpleTask implements Runnable{

		
		private String taskName;
		
		public SimpleTask(String taskName) {
			this.taskName = taskName;
		}
		
		public void run() {
			
			System.out.println("执行线程"+taskName+"在"+Thread.currentThread().getName());
			
		}
		
		
	}

}
