/*
 Navicat Premium Data Transfer

 Source Server         : ali3
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : rm-bp102hwn0bc9tpy0f7o.mysql.rds.aliyuncs.com:3306
 Source Schema         : manhuabenweb

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 10/08/2019 20:58:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ts_book
-- ----------------------------
DROP TABLE IF EXISTS `ts_book`;
CREATE TABLE `ts_book` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `book_url` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL COMMENT 'book的url',
  `book_index` int(100) NOT NULL COMMENT 'book的索引',
  `book_name` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL COMMENT 'book的name',
  `book_size` int(100) DEFAULT NULL COMMENT 'book的size',
  `book_covers` mediumblob COMMENT 'book的封面',
  `book_covers_url` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL COMMENT 'book的封面的url',
  `create_time` datetime DEFAULT NULL COMMENT '创建的日期',
  `local_image_url` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL COMMENT '本地图片的url',
  PRIMARY KEY (`id`),
  UNIQUE KEY `1` (`book_url`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=3039 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Table structure for ts_page
-- ----------------------------
DROP TABLE IF EXISTS `ts_page`;
CREATE TABLE `ts_page` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `page_url` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL COMMENT '页面的url',
  `page_image_url` varchar(200) COLLATE utf8_vietnamese_ci DEFAULT NULL COMMENT '页面image的url',
  `page_image` mediumblob COMMENT '页面image的流',
  `page_index` int(100) NOT NULL COMMENT '页面索引',
  `book_id` int(100) NOT NULL COMMENT '对应book的id',
  `loacl_image_url` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL COMMENT '本地的url',
  PRIMARY KEY (`id`),
  UNIQUE KEY `1` (`page_url`) USING HASH,
  KEY `2` (`page_url`) USING BTREE,
  KEY `3` (`page_image_url`) USING BTREE,
  KEY `4` (`page_index`) USING BTREE,
  KEY `5` (`book_id`) USING BTREE,
  KEY `6` (`loacl_image_url`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=209141 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Table structure for ts_param
-- ----------------------------
DROP TABLE IF EXISTS `ts_param`;
CREATE TABLE `ts_param` (
  `key` varchar(40) COLLATE utf8_vietnamese_ci NOT NULL,
  `value` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `des` varchar(40) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Table structure for ts_user
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `account` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL COMMENT '账号',
  `passwd` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL COMMENT '密码',
  `salt` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL COMMENT '随机生成的加密salt',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

-- ----------------------------
-- Table structure for ts_web_page
-- ----------------------------
DROP TABLE IF EXISTS `ts_web_page`;
CREATE TABLE `ts_web_page` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `web_page_url` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `web_page_index` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

SET FOREIGN_KEY_CHECKS = 1;
