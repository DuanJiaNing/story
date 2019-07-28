-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.16-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 account 的数据库结构
CREATE DATABASE IF NOT EXISTS `account` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `account`;

-- 导出  表 account.account 结构
CREATE TABLE IF NOT EXISTS `account` (
  `id`          int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username`    varchar(100)     NOT NULL,
  `password`    varchar(200)     NOT NULL,
  `insert_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 数据导出被取消选择。
-- 导出  表 account.link 结构
CREATE TABLE IF NOT EXISTS `link` (
  `id`          int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id`  int(11) unsigned NOT NULL,
  `icon`        varchar(200)              DEFAULT NULL,
  `title`       varchar(100)     NOT NULL,
  `url`         varchar(200)     NOT NULL,
  `intro`       varchar(300)              DEFAULT NULL,
  `insert_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_url` (`account_id`, `url`),
  CONSTRAINT `account_link_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 数据导出被取消选择。
-- 导出  表 account.profile 结构
CREATE TABLE IF NOT EXISTS `profile` (
  `id`          int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id`  int(11) unsigned NOT NULL,
  `phone`       varchar(20)               DEFAULT NULL,
  `email`       varchar(100)              DEFAULT NULL,
  `about_me`    text,
  `motto`       text,
  `avatar`      varchar(200)              DEFAULT NULL,
  `insert_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `account_profile_ibfk_3` (`account_id`),
  CONSTRAINT `account_profile_ibfk_3` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 数据导出被取消选择。
-- 导出  表 account.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `id`          int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id`  int(11) unsigned NOT NULL,
  `role`        varchar(200)     NOT NULL,
  `intro`       varchar(300)              DEFAULT NULL,
  `insert_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_url` (`account_id`, `role`),
  CONSTRAINT `account_role_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 数据导出被取消选择。
-- 导出  表 account.setting 结构
CREATE TABLE IF NOT EXISTS `setting` (
  `id`          int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id`  int(11) unsigned NOT NULL,
  `insert_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `account_setting_ibfk_1` (`account_id`),
  CONSTRAINT `account_setting_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS = IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
