package com.mall.parking.resource.service;

import java.util.List;

import com.mall.parking.resource.entity.Stall;

/**
 * @author https://backkoms.github.io/
 *
 */
public interface StallService {

	int occupy(String json);

	int exist(String json);

	List<Stall> list(String json);

}
