package com.wbd.spring.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 1.调度器， scheduler
 * 2.任务  job
 * 3.触发器 trigger
 * ，在什么时候， 执行什么任务，  由调度器来进行调度
 * 
 * job.trigger注册到scheduler 
 * 
 * @author jwh
 *
 */
public class SimpJob implements Job{ //具体执行的任务

	private static int  end = 100;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		end--;
		System.out.println("end=="+end);
		System.out.println(context.getJobDetail().getJobClass().getName());
	}

}
