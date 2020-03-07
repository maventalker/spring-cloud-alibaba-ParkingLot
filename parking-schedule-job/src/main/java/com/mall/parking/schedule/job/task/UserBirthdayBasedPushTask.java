package com.mall.parking.schedule.job.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.mall.parking.common.entity.Member;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.schedule.job.client.MemberServiceClient;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@Component
@Slf4j
public class UserBirthdayBasedPushTask {
	
	@Autowired
	MemberServiceClient memberService;

	@Scheduled(cron = " 0/5 * * * * ?")
	@SchedulerLock(name = "scheduledTaskName")
	public void scheduledTask() {
		try {
			String members = memberService.list();
			List<Member> array  = JSONArray.parseArray(members, Member.class);
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime time = LocalDateTime.now();
			String curTime = df.format(time);
			for (Member one : array) {
				if (curTime.equals(one.getBirth())) {
					log.info(" send sms to  " + one.getPhone() );
				}
			}
		} catch (BusinessException e) {
			log.error("catch exception " + e.getMessage());
		}
		
		log.info("Task running at = "  + LocalDateTime.now());
	}
}
