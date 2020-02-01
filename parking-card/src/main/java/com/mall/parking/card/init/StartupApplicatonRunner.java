package com.mall.parking.card.init;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mall.parking.common.bean.ParkingConstant;

/**
 * @author https://backkoms.github.io/
 *
 */
@Component
@Order(0)
public class StartupApplicatonRunner implements ApplicationRunner {

	@Autowired
	Redisson redisson;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		RAtomicLong atomicLong = redisson.getAtomicLong(ParkingConstant.cache.grouponCodeAmtKey);
		atomicLong.set(ParkingConstant.cache.grouponCodeAmt);
	}

}
