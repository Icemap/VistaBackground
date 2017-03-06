/*
Navicat MySQL Data Transfer

Source Server         : LocalDatabase
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : vistadb

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-06 16:01:37
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
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('8', '王琦智', '1', '1');

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
-- Records of proj
-- ----------------------------
INSERT INTO `proj` VALUES ('5', '荔湾湖附近调查项目', '荔湾湖的', '8');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` varchar(11) DEFAULT NULL,
  `income` varchar(11) DEFAULT NULL,
  `homeAddress` varchar(100) DEFAULT NULL,
  `workAddress` varchar(100) DEFAULT NULL,
  `projId` int(11) DEFAULT NULL,
  `vistaMatrix` varchar(1000) DEFAULT NULL,
  `vistaResult` varchar(200) DEFAULT NULL,
  `hold` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12', '21~25岁', '9k~10k', 'gdbdbdv', '大慈大悲', '5', '[{\"index\":\"1:5\",\"value\":\"50:50\"},{\"index\":\"1:6\",\"value\":\"50:50\"},{\"index\":\"1:7\",\"value\":\"50:50\"},{\"index\":\"5:6\",\"value\":\"50:50\"},{\"index\":\"5:7\",\"value\":\"50:50\"},{\"index\":\"6:7\",\"value\":\"50:50\"}]', '1:5:6:7 = 0.25:0.25:0.25:0.25', null);

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

-- ----------------------------
-- Records of vista
-- ----------------------------
INSERT INTO `vista` VALUES ('1', 'http://118.193.195.210/pano/1-1.html', '荔湾湖西', '5', '113.236913', '23.126705');
INSERT INTO `vista` VALUES ('5', 'http://118.193.195.210/pano/1-2.html', '荔湾湖东', '5', '113.242802', '23.127672');
INSERT INTO `vista` VALUES ('6', 'http://118.193.195.210/pano/1-3.html', '荔湾湖南', '5', '113.239366', '23.124436');
INSERT INTO `vista` VALUES ('7', 'http://118.193.195.210/pano/2-1.html', '荔湾湖北', '5', '113.242865', '23.129027');
