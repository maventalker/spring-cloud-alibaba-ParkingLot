/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : park_member

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/02/2020 15:25:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `birth` varchar(10) DEFAULT NULL COMMENT '生日',
  `full_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息';

-- ----------------------------
-- Table structure for month_card
-- ----------------------------
DROP TABLE IF EXISTS `month_card`;
CREATE TABLE `month_card` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `card_no` varchar(20) DEFAULT NULL COMMENT '会员卡号',
  `start` varchar(16) DEFAULT NULL COMMENT '有效期起始',
  `ends` varchar(16) DEFAULT NULL COMMENT '有效期截止',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员月卡信息';

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `plate_no` varchar(10) DEFAULT NULL COMMENT '车牌号',
  `vehicle_inf` varchar(50) DEFAULT NULL COMMENT '车辆型号',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员车辆';

SET FOREIGN_KEY_CHECKS = 1;
