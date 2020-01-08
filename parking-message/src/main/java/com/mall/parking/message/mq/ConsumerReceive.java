package com.mall.parking.message.mq;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
@Service
@Slf4j
public class ConsumerReceive {

	@StreamListener("input")
	public void receiveInput(String json) throws BusinessException{
		log.info("Receive input msg = " +json +" by RocketMQ...");
		
	}
	
	
//	@StreamListener(MessageSink.Input2)
//	public void receiveInput2(String json) throws BusinessException{
//		log.info("------>>>>>>>>>>>>>>Receive publish msg = " +json +" by RocketMQ...");
//		
//	}
}
