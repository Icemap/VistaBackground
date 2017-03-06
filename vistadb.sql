/*
Navicat MySQL Data Transfer

Source Server         : LocalDatabase
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : vistadb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-01-05 17:57:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for proj
-- ----------------------------
DROP TABLE IF EXISTS `proj`;
CREATE TABLE `proj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `belong` int(11) DEFAULT NULL COMMENT '属于哪个managerId',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `income` int(11) DEFAULT NULL,
  `homeAddress` varchar(100) DEFAULT NULL,
  `workAddress` varchar(100) DEFAULT NULL,
  `projId` int(11) DEFAULT NULL,
  `vistaMatrix` varchar(1000) DEFAULT NULL,
  `vistaResult` varchar(200) DEFAULT NULL,
  `hold` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vista
-- ----------------------------
DROP TABLE IF EXISTS `vista`;
CREATE TABLE `vista` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(500) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `belong` int(11) DEFAULT NULL COMMENT '属于哪个projId',
  `lon` double DEFAULT NULL,
  `lat` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
