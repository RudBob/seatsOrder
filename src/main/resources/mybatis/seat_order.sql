/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : seat_order

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2018-09-26 10:46:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for balck_list
-- ----------------------------
DROP TABLE IF EXISTS `balck_list`;
CREATE TABLE `balck_list` (
  `sid` varchar(20) NOT NULL,
  `into_date` datetime DEFAULT NULL,
  `residue_days` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of balck_list
-- ----------------------------

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `bid` int(11) NOT NULL,
  `bName` varchar(30) DEFAULT NULL,
  `max_floor` int(11) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('1', '东风图书馆', '7');
INSERT INTO `building` VALUES ('2', '科学图书馆', '9');
INSERT INTO `building` VALUES ('3', '禹州图书馆', '5');

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `rid` int(11) NOT NULL,
  `rname` varchar(20) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `seat_num` int(11) DEFAULT NULL,
  `stu_num` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of region
-- ----------------------------

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `tid` int(20) NOT NULL,
  `rid` int(11) DEFAULT NULL,
  `state` tinyint(11) DEFAULT NULL,
  `sid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of seat
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `state` int(6) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for student_seat
-- ----------------------------
DROP TABLE IF EXISTS `student_seat`;
CREATE TABLE `student_seat` (
  `s_tid` int(11) NOT NULL,
  `sid` varchar(20) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`s_tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- ----------------------------
-- Records of student_seat
-- ----------------------------
