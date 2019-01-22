package com.wbd.spring.quartz;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class SimpleTriggerRunner {

	public static void main(String[] args) throws ParseException {
		
		//1.创建任务
		JobDetail jobDetail  = new JobDetailImpl("job1","group1",SimpJob.class);
		
		//2.创建触发器
//		SimpleTriggerImpl simpleTrigger  = new SimpleTriggerImpl("trigger1","tgroup1");
//		
//		//3设置触发器基本信息
//		
//		simpleTrigger.setStartTime(new Date());
//		
//		simpleTrigger.setRepeatCount(100); //重复执行次数
//		simpleTrigger.setRepeatInterval(2000); //间隔多少秒 ，间隔2秒
		
		//CroTigger触发器
		CronTriggerImpl cronTigger = new CronTriggerImpl("trigger2","group2");
		
		CronExpression exp=  new CronExpression("0/6 * * * * ?");
		
		cronTigger.setCronExpression(exp);
		
		//4.通过调度器工厂类获取任务调度器
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			
		//5. 注册，job与触发器
			scheduler.scheduleJob(jobDetail, cronTigger);
	
		//6.调度启动
			scheduler.start();
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
