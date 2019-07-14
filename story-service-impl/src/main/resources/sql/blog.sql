
CREATE DATABASE IF NOT EXISTS `story`
USE `story`;

CREATE TABLE IF NOT EXISTS `story` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `writer_id` int(11) unsigned NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  `title` varchar(80) NOT NULL,
  `content` longtext NOT NULL,
  `content_md` longtext NOT NULL,
  `summary` varchar(400) NOT NULL,
  `key_words` varchar(400) DEFAULT NULL,
  `release_date` datetime NOT NULL,
  `nearest_modify_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `writer_id` (`writer_id`,`title`),
  CONSTRAINT `story_ibfk_1` FOREIGN KEY (`writer_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `register_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `link` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `writer_id` int(10) unsigned NOT NULL,
  `icon_id` int(10) unsigned DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `url` varchar(200) NOT NULL,
  `bewrite` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `writer_id` (`writer_id`,`url`),
  KEY `icon_id` (`icon_id`),
  CONSTRAINT `writer_link_ibfk_1` FOREIGN KEY (`writer_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `writer_id` int(11) unsigned NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `about_me` text,
  `intro` text,
  `avatar_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `writer_id` (`writer_id`),
  UNIQUE KEY `phone` (`phone`),
  KEY `avatar_id` (`avatar_id`),
  CONSTRAINT `writer_profile_ibfk_3` FOREIGN KEY (`writer_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `setting` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `writer_id` int(10) unsigned NOT NULL,
  `main_page_nav_pos` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `writer_id` (`writer_id`),
  CONSTRAINT `writer_setting_ibfk_1` FOREIGN KEY (`writer_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `writer_id` int(10) unsigned DEFAULT NULL,
  `icon_id` int(10) unsigned DEFAULT NULL,
  `title` varchar(20) NOT NULL,
  `bewrite` text,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `writer_id` (`writer_id`,`title`),
  KEY `icon_id` (`icon_id`),
  CONSTRAINT `story_category_ibfk_1` FOREIGN KEY (`writer_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `story_category_rela` (
  `id` int(11) unsigned NOT NULL,
  `story_id` int(11) unsigned NOT NULL,
  `category_id` int(11) unsigned NOT NULL,
  `insert_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_story_category_rela_story` (`story_id`),
  KEY `FK_story_category_rela_story_category` (`category_id`),
  CONSTRAINT `FK_story_category_rela_story` FOREIGN KEY (`story_id`) REFERENCES `story` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_story_category_rela_story_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `collect` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `story_id` int(11) unsigned NOT NULL,
  `collector_id` int(10) unsigned NOT NULL,
  `reason` text,
  `collect_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `story_id` (`story_id`,`collector_id`),
  KEY `writer_id` (`collector_id`),
  CONSTRAINT `story_collect_ibfk_1` FOREIGN KEY (`story_id`) REFERENCES `story` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `story_collect_ibfk_2` FOREIGN KEY (`collector_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `story_id` int(10) unsigned NOT NULL,
  `spokesman_id` int(10) unsigned DEFAULT NULL,
  `listener_id` int(10) unsigned DEFAULT NULL,
  `content` text NOT NULL,
  `state` int(11) NOT NULL,
  `release_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `story_id` (`story_id`),
  KEY `spokesman_id` (`spokesman_id`),
  KEY `listener_id` (`listener_id`),
  CONSTRAINT `story_comment_ibfk_1` FOREIGN KEY (`story_id`) REFERENCES `story` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `story_comment_ibfk_2` FOREIGN KEY (`spokesman_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `story_comment_ibfk_3` FOREIGN KEY (`listener_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `label` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `writer_id` int(10) unsigned NOT NULL,
  `title` varchar(20) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `writer_id_2` (`writer_id`,`title`),
  KEY `writer_id` (`writer_id`),
  CONSTRAINT `story_label_ibfk_1` FOREIGN KEY (`writer_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `story_label_rela` (
  `id` int(11) unsigned NOT NULL,
  `story_id` int(11) unsigned NOT NULL,
  `label_id` int(11) unsigned NOT NULL,
  `insert_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_story_label_rela_story` (`story_id`),
  KEY `FK_story_label_rela_story_label` (`label_id`),
  CONSTRAINT `FK_story_label_rela_story` FOREIGN KEY (`story_id`) REFERENCES `story` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_story_label_rela_story_label` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文和标签关联表';

CREATE TABLE IF NOT EXISTS `like` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `story_id` int(10) unsigned NOT NULL,
  `liker_id` int(10) unsigned NOT NULL,
  `like_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admirer_id` (`liker_id`,`story_id`),
  KEY `story_like_ibfk_1` (`story_id`),
  CONSTRAINT `story_like_ibfk_1` FOREIGN KEY (`story_id`) REFERENCES `story` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `story_like_ibfk_2` FOREIGN KEY (`liker_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `story_statistics` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `story_id` int(10) unsigned NOT NULL DEFAULT '0',
  `comment_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '评论次数',
  `view_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `reply_comment_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '作者回复该故事评论的次数',
  `collect_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '收藏次数',
  `like_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '喜欢次数',
  `word_count` int(11) NOT NULL DEFAULT '0' COMMENT '故事字数',
  `release_date` date NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `story_id` (`story_id`),
  CONSTRAINT `story_statistics_ibfk_1` FOREIGN KEY (`story_id`) REFERENCES `story` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;




