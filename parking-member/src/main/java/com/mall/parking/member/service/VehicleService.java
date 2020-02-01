package com.mall.parking.member.service;

import com.mall.parking.common.exception.BusinessException;
import com.mall.parking.member.entity.Vehicle;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface VehicleService {

	int addVehicle(String json) throws BusinessException;

	Vehicle getVehicle(String vehicleNo) throws BusinessException;
}
