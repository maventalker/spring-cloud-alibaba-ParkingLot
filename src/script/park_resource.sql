/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : park_resource

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/02/2020 15:28:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brake
-- ----------------------------
DROP TABLE IF EXISTS `brake`;
CREATE TABLE `brake` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `code` varchar(20) DEFAULT NULL COMMENT '编号',
  `desc` varchar(50) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='停车场闸机';

-- ----------------------------
-- Table structure for stall
-- ----------------------------
DROP TABLE IF EXISTS `stall`;
CREATE TABLE `stall` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `code` varchar(10) DEFAULT NULL COMMENT '编号',
  `is_parked` int(2) DEFAULT NULL COMMENT '是否被占用',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车位表';

-- ----------------------------
-- Table structure for stall_parked
-- ----------------------------
DROP TABLE IF EXISTS `stall_parked`;
CREATE TABLE `stall_parked` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `stall_id` varchar(32) DEFAULT NULL COMMENT '车位编号',
  `plate_no` varchar(30) DEFAULT NULL COMMENT '车牌',
  `mtype` int(2) DEFAULT NULL COMMENT '0入场，1出场',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `version` int(4) DEFAULT '0' COMMENT '版本',
  `state` int(4) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车位停靠记录';

SET FOREIGN_KEY_CHECKS = 1;
