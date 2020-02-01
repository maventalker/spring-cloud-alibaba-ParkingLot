package com.mall.parking.carwash.serv.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.carwash.api.bean.CarWash;
import com.mall.parking.carwash.api.itf.WashService;
import com.mall.parking.carwash.serv.mapper.CarWashMapper;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Service(protocol = "dubbo")
@Slf4j
public class WashServiceImpl implements WashService {

	@Autowired
	CarWashMapper carWashMapper;

	@Override
	public int wash(String json) throws BusinessException {
		CarWash carWash = JSONObject.parseObject(json, CarWash.class);
		int rtn = carWashMapper.insertSelective(carWash);
		log.info("car wash data = " + json + "> write suc...");
		
		return rtn;
	}

}
