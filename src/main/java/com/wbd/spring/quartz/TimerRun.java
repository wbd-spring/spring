package com.wbd.spring.quartz;

import java.util.Timer;
import java.util.TimerTask;

public class TimerRun {

	public static void main(String[] args) {

		Timer timer = new Timer();
		
		TimerTask task = new SimpleTimerTask();
		
		timer.scheduleAtFixedRate(task, 1000l, 3000l);
		
	}

}
