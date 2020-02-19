/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : park_charge

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/02/2020 15:28:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for charging_rule
-- ----------------------------
DROP TABLE IF EXISTS `charging_rule`;
CREATE TABLE `charging_rule` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `start` int(4) DEFAULT NULL COMMENT '停车时间起始',
  `end` int(4) DEFAULT NULL COMMENT '停车时间结束',
  `fee` float DEFAULT NULL COMMENT '收费',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计费规则';

-- ----------------------------
-- Table structure for entrance
-- ----------------------------
DROP TABLE IF EXISTS `entrance`;
CREATE TABLE `entrance` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `plate_no` varchar(10) DEFAULT NULL COMMENT '车牌',
  `brake_id` varchar(32) DEFAULT NULL COMMENT '闸机号',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `no_idx` (`plate_no`),
  KEY `member_idx` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆入场';

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vexists
-- ----------------------------
DROP TABLE IF EXISTS `vexists`;
CREATE TABLE `vexists` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员编号',
  `brake_id` varchar(32) DEFAULT NULL COMMENT '闸机号',
  `plate_no` varchar(32) DEFAULT NULL COMMENT '车牌号',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `no_idx` (`plate_no`),
  KEY `member_idx` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆驶出';

SET FOREIGN_KEY_CHECKS = 1;
