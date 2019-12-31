package com.mall.parking.member.service;

import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.entity.Vehicle;

/**
 * @author 公众号：歪脖贰点零 See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
public interface VehicleService {

	int addVehicle(String json) throws BusinessException;

	Vehicle getVehicle(String vehicleNo) throws BusinessException;
}
