package com.six.springboot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class QuartzService {


	// 每5秒钟启动
//	 @Scheduled(cron = "0/5 * * * * ?")
	public void timerToNow() {
		System.out.println("now time a:" + formatNow());
	}

	private String formatNow() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
}
