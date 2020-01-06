package com.mall.parking.resource.service;

/**
 * @author 公众号：歪脖贰点零 , See more at : https://xiaozhuanlan.com/msa-practice
 *
 */
public interface StallService {

	int occupy(String json);

	int exist(String json);

}
