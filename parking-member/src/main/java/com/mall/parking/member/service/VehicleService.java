package com.mall.parking.member.service;

import com.mall.parking.common.entity.Vehicle;
import com.mall.parking.common.exception.BusinessException;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface VehicleService {

	int addVehicle(String json) throws BusinessException;

	Vehicle getVehicle(String vehicleNo) throws BusinessException;
}
