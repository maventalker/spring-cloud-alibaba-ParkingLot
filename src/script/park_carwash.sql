/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : park_carwash

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/02/2020 15:32:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_wash
-- ----------------------------
DROP TABLE IF EXISTS `car_wash`;
CREATE TABLE `car_wash` (
  `id` varchar(32) NOT NULL,
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `plate_no` varchar(10) DEFAULT NULL COMMENT '车牌号',
  `ticket_code` varchar(20) DEFAULT NULL COMMENT '洗车券编码',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
