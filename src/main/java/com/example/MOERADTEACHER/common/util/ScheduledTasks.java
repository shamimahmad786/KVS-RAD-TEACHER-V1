package com.example.MOERADTEACHER.common.util;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import com.moe.rad.service.MailService;

//import com.moe.rad.service.KVSMailService;
//import com.moe.red.service.ScheduledTasks;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() throws SQLException {
//		log.info("The time is now {}", dateFormat.format(new Date()));
		
//		new MailService().AutoMail();
//		new KVSMailService().
	}
}