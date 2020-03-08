package com.mall.parking.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mall.parking.card.mapper.MemberCardMapper;
import com.mall.parking.card.service.MemberCardService;
import com.mall.parking.common.entity.MemberCard;
import com.mall.parking.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author https://backkoms.github.io/
 *
 */
@Service
@Slf4j
public class MemberCardServiceImpl implements MemberCardService {

	
	@Autowired
	MemberCardMapper cardMapper;

	@Override
	public int addMemberCard(String json) throws BusinessException {
		MemberCard card = JSONObject.parseObject(json,MemberCard.class);
		log.info("add member card " +json);
		return cardMapper.insertSelective(card);
	}

	@Override
	public int updateMemberCard(String json) throws BusinessException {
		MemberCard card = JSONObject.parseObject(json,MemberCard.class);
		log.info("update member card = " +json);
		return cardMapper.updateByPrimaryKeySelective(card);
	}

	@Override
	public MemberCard getMemberCard(String memberId) {
		return cardMapper.selectByPrimaryKey(memberId);
	}
}
