package com.wbd.spring.quartz;

import java.util.Date;
import java.util.TimerTask;

/**
 * jdk的 timer
 * @author jwh
 *
 */
public class SimpleTimerTask extends TimerTask{

	private int count=0;
	
	@Override
	public void run() {
		
		System.out.println("java timer");
		
		Date time = (new Date(scheduledExecutionTime()));
		
		System.out.println("任务执行点:"+time);
		
		if(count++>8) {
			cancel();
		}
		
	}
	
	

}
