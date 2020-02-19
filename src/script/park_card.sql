/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : park_card

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/02/2020 15:30:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exchange
-- ----------------------------
DROP TABLE IF EXISTS `exchange`;
CREATE TABLE `exchange` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `card_qty` int(11) DEFAULT NULL COMMENT '积分数量',
  `ctype` int(4) DEFAULT NULL COMMENT '0优惠券，1洗车券',
  `code` varchar(30) DEFAULT NULL COMMENT '券编码',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分兑换';

-- ----------------------------
-- Table structure for member_card
-- ----------------------------
DROP TABLE IF EXISTS `member_card`;
CREATE TABLE `member_card` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `cur_qty` varchar(20) DEFAULT NULL COMMENT '当前可用积分',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员积分';

-- ----------------------------
-- Table structure for member_sign
-- ----------------------------
DROP TABLE IF EXISTS `member_sign`;
CREATE TABLE `member_sign` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `cnt` int(4) DEFAULT NULL COMMENT '积分数量',
  `ctype` int(4) DEFAULT NULL COMMENT '0签到，1商场消费',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员签到';

SET FOREIGN_KEY_CHECKS = 1;
