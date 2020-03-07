//package com.mall.parking.schedule.job.task;
//
//import java.time.LocalDateTime;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
//
//@Component
//@Slf4j
//public class AnotherTask {
//
//	
//	@Scheduled(cron = " 0/5 * * * * ?")
//	@SchedulerLock(name = "anotherScheduledTaskName")
//	public void scheduledTask() {
//		log.info("another task running -- " + LocalDateTime.now()) ;
//	}
//}
