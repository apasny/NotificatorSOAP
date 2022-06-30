package com.apasny.tracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.apasny.api.NotificatorService;

public class TrackingHandler {

	public void timeTracker() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				new NotificatorService().sendNotification();
			}
		}, 5000, 10000);
		
	}
	
	public List<String> untrackedUsers() {
		return new ArrayList<>();
	}
}
