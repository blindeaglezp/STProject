/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : onlinetest

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-08-31 12:07:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adm_id` varchar(20) NOT NULL,
  `adm_password` varchar(20) NOT NULL,
  `adm_name` varchar(10) NOT NULL,
  `adm_sex` varchar(2) NOT NULL,
  `adm_age` int(2) NOT NULL,
  `adm_job` varchar(20) NOT NULL,
  `adm_phone` varchar(11) NOT NULL,
  `adm_email` varchar(50) NOT NULL,
  `adm_address` varchar(50) NOT NULL,
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `choicequestion`
-- ----------------------------
DROP TABLE IF EXISTS `choicequestion`;
CREATE TABLE `choicequestion` (
  `cq_id` varchar(20) NOT NULL,
  `cq_description` varchar(200) DEFAULT NULL,
  `cq_choice` varchar(50) DEFAULT NULL,
  `cq_majorid` varchar(20) DEFAULT NULL,
  `cq_courseid` varchar(20) DEFAULT NULL,
  `cq_testpaperid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choicequestion
-- ----------------------------

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `cla_id` varchar(20) NOT NULL,
  `cla_name` varchar(50) NOT NULL,
  `cla_majorid` varchar(20) NOT NULL,
  `cla_gradeid` varchar(20) NOT NULL,
  PRIMARY KEY (`cla_id`),
  KEY `cla_majorid` (`cla_majorid`),
  KEY `cla_gradeid` (`cla_gradeid`),
  CONSTRAINT `cla_gradeid` FOREIGN KEY (`cla_gradeid`) REFERENCES `grade` (`gra_id`),
  CONSTRAINT `cla_majorid` FOREIGN KEY (`cla_majorid`) REFERENCES `major` (`maj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1304', '1304', '1', '2013');

-- ----------------------------
-- Table structure for `connect`
-- ----------------------------
DROP TABLE IF EXISTS `connect`;
CREATE TABLE `connect` (
  `name` varchar(20) NOT NULL,
  `value` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of connect
-- ----------------------------
INSERT INTO `connect` VALUES ('QQ', '2430168648');
INSERT INTO `connect` VALUES ('电话', '18735424437');
INSERT INTO `connect` VALUES ('邮箱', 'zhangpeng19950509@126.com');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cou_id` varchar(20) NOT NULL,
  `cou_name` varchar(50) NOT NULL,
  `cou_majorid` varchar(50) NOT NULL,
  `cou_gradeId` varchar(20) NOT NULL,
  PRIMARY KEY (`cou_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for `fillblanksquestion`
-- ----------------------------
DROP TABLE IF EXISTS `fillblanksquestion`;
CREATE TABLE `fillblanksquestion` (
  `fbq_id` varchar(20) NOT NULL,
  `fbq_description` varchar(200) DEFAULT NULL,
  `fbq_blanks` varchar(50) DEFAULT NULL,
  `fbq_testpaperid` varchar(20) DEFAULT NULL,
  `fbq_courseid` varchar(20) DEFAULT NULL,
  `fbq_majorid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`fbq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fillblanksquestion
-- ----------------------------

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gra_id` varchar(20) NOT NULL,
  `gra_name` varchar(20) NOT NULL,
  `gra_majorid` varchar(20) NOT NULL,
  PRIMARY KEY (`gra_id`),
  KEY `gra_majorid` (`gra_majorid`),
  CONSTRAINT `gra_majorid` FOREIGN KEY (`gra_majorid`) REFERENCES `major` (`maj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('2013', '大三', '1');

-- ----------------------------
-- Table structure for `judgequestion`
-- ----------------------------
DROP TABLE IF EXISTS `judgequestion`;
CREATE TABLE `judgequestion` (
  `jq_id` varchar(20) NOT NULL,
  `jq_description` varchar(200) DEFAULT NULL,
  `jq_trueorfalse` varchar(10) DEFAULT NULL,
  `jq_testpaperid` varchar(20) DEFAULT NULL,
  `jq_courseid` varchar(20) DEFAULT NULL,
  `jq_major` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`jq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of judgequestion
-- ----------------------------

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `maj_id` varchar(20) NOT NULL,
  `maj_name` varchar(50) NOT NULL,
  PRIMARY KEY (`maj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件工程');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mes_id` int(11) NOT NULL AUTO_INCREMENT,
  `mes_title` varchar(30) DEFAULT NULL,
  `mes_content` varchar(1000) DEFAULT NULL,
  `mes_attachment` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`mes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `sco_id` int(11) NOT NULL DEFAULT '0',
  `sco_studentid` varchar(20) DEFAULT NULL,
  `sco_courseid` varchar(20) DEFAULT NULL,
  `sco_value` int(11) DEFAULT NULL,
  PRIMARY KEY (`sco_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` varchar(20) NOT NULL,
  `stu_password` varchar(20) NOT NULL,
  `stu_name` varchar(10) NOT NULL,
  `stu_sex` varchar(2) NOT NULL,
  `stu_age` int(2) NOT NULL,
  `stu_majorid` varchar(20) NOT NULL,
  `stu_gradeid` varchar(20) NOT NULL,
  `stu_classid` varchar(20) NOT NULL,
  `stu_phone` varchar(11) NOT NULL,
  `stu_email` varchar(50) NOT NULL,
  `stu_address` varchar(50) NOT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `stu_majorid` (`stu_majorid`),
  KEY `stu_classid` (`stu_classid`),
  KEY `stu_gradeid` (`stu_gradeid`),
  CONSTRAINT `stu_classid` FOREIGN KEY (`stu_classid`) REFERENCES `class` (`cla_id`),
  CONSTRAINT `stu_gradeid` FOREIGN KEY (`stu_gradeid`) REFERENCES `grade` (`gra_id`),
  CONSTRAINT `stu_majorid` FOREIGN KEY (`stu_majorid`) REFERENCES `major` (`maj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20131612941', 'dshb(2430168648)', '张鹏', '男', '20', '1', '2013', '1304', '18735424437', 'zhangpeng19950509@126.com', '山西农业大学');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tea_id` varchar(20) NOT NULL,
  `tea_password` varchar(20) NOT NULL,
  `tea_name` varchar(10) NOT NULL,
  `tea_sex` varchar(2) NOT NULL,
  `tea_age` int(2) NOT NULL,
  `tea_majorid` varchar(20) NOT NULL,
  `tea_courseid` varchar(20) NOT NULL,
  `tea_phone` varchar(11) NOT NULL,
  `tea_email` varchar(50) NOT NULL,
  `tea_address` varchar(50) NOT NULL,
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `testpaper`
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper` (
  `tp_id` varchar(20) NOT NULL,
  `tp_name` varchar(50) DEFAULT NULL,
  `tp_courseid` varchar(20) DEFAULT NULL,
  `tp_majorid` varchar(20) DEFAULT NULL,
  `tp_createdate` date DEFAULT NULL,
  PRIMARY KEY (`tp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
