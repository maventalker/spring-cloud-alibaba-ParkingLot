package com.mall.parking.member.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.common.entity.Vehicle;
import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.entity.MonthCard;
import com.mall.parking.member.entity.MonthCardExample;
import com.mall.parking.member.mapper.MonthCardMapper;
import com.mall.parking.member.service.MonthCardService;
import com.mall.parking.member.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Service
@Slf4j
public class MonthCardServiceImpl implements MonthCardService {

	@Autowired
	MonthCardMapper cardMapper;

	@Autowired
	VehicleService vehicleService;

	@Override
	public int addMonthCard(String json) throws BusinessException{
		MonthCard card = JSONObject.parseObject(json, MonthCard.class);
		return cardMapper.insertSelective(card);
	}

	@Override
	public boolean isMonthCardUser(String vehicleNo) throws BusinessException{
		Vehicle vehicle = vehicleService.getVehicle(vehicleNo);

		MonthCardExample monthCardExample = new MonthCardExample();
		monthCardExample.createCriteria().andMemberIdEqualTo(vehicle.getMemberId());
		List<MonthCard> cards = cardMapper.selectByExample(monthCardExample);
		if (CollectionUtils.isEmpty(cards)) {
			log.warn("VehicleNo = " + vehicleNo +  " ,not monthcard user !");
			return false;
		} else {
			return true;
		}
	}

}
