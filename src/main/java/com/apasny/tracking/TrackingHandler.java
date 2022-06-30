package com.apasny.tracking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.apasny.api.NotificatorService;

public class TrackingHandler {

	public void timeTracker() {
		
		LocalTime localTime = LocalTime.of(22, 14);
		
		LocalDateTime sendingTime = LocalDateTime.of(LocalDate.now(), localTime);
		
		Date date = Date.from(sendingTime.atZone(ZoneId.systemDefault()).toInstant());
		
		System.out.print(sendingTime);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				new NotificatorService().sendNotification();
			}
		}, date, TimeUnit.MINUTES.toMillis(30));

	}

	public List<String> untrackedUsers() {
		return new ArrayList<>();
	}
}
