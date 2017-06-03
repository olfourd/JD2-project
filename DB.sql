<?xml version="1.0" encoding="UTF-8"?>
<schemadesigner version="6.5">
<source>
<database charset="utf8" collation="utf8_bin">jd2_project</database>
</source>
<canvas zoom="90">
<tables>
<table name="hero" view="colnames">
<left>244</left>
<top>147</top>
<width>70</width>
<height>127</height>
<sql_create_table>CREATE TABLE `hero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci</sql_create_table>
</table>
<table name="ability" view="colnames">
<left>39</left>
<top>149</top>
<width>115</width>
<height>142</height>
<sql_create_table>CREATE TABLE `ability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `key_ability` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HERO_ID` int(11) NOT NULL,
  `pass_to_video` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hero` (`HERO_ID`),
  CONSTRAINT `ability_ibfk_1` FOREIGN KEY (`HERO_ID`) REFERENCES `hero` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=671 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci</sql_create_table>
</table>
<table name="messages_from_topic_hero" view="colnames">
<left>1544</left>
<top>340</top>
<width>220</width>
<height>130</height>
<sql_create_table>CREATE TABLE `messages_from_topic_hero` (
  `MESSAGE_ID` int(11) NOT NULL,
  `likes` int(11) DEFAULT '0',
  `TOPICS_HEROES_ID` int(11) NOT NULL,
  KEY `message` (`MESSAGE_ID`),
  KEY `TOPICS_HEROES_ID` (`TOPICS_HEROES_ID`),
  CONSTRAINT `messages_from_topic_hero_ibfk_1` FOREIGN KEY (`MESSAGE_ID`) REFERENCES `message` (`id`),
  CONSTRAINT `messages_from_topic_hero_ibfk_2` FOREIGN KEY (`TOPICS_HEROES_ID`) REFERENCES `topics_heroes` (`TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="user" view="colnames">
<left>601</left>
<top>165</top>
<width>122</width>
<height>173</height>
<sql_create_table>CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `nick_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin NOT NULL,
  `pass_to_picture` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="message" view="colnames">
<left>1196</left>
<top>364</top>
<width>86</width>
<height>119</height>
<sql_create_table>CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `text` text COLLATE utf8_bin NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user` (`USER_ID`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="messages_from_news" view="colnames">
<left>1602</left>
<top>535</top>
<width>198</width>
<height>96</height>
<sql_create_table>CREATE TABLE `messages_from_news` (
  `MESSAGE_ID` int(11) NOT NULL,
  `likes` int(11) DEFAULT '0',
  `NEWS_ID` int(11) NOT NULL,
  KEY `MESSAGE_ID` (`MESSAGE_ID`),
  KEY `NEWS_ID` (`NEWS_ID`),
  CONSTRAINT `messages_from_news_ibfk_1` FOREIGN KEY (`MESSAGE_ID`) REFERENCES `message` (`id`),
  CONSTRAINT `messages_from_news_ibfk_2` FOREIGN KEY (`NEWS_ID`) REFERENCES `news` (`TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="topic" view="colnames">
<left>955</left>
<top>533</top>
<width>148</width>
<height>126</height>
<sql_create_table>CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `text` text COLLATE utf8_bin NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="topics_heroes" view="colnames">
<left>422</left>
<top>735</top>
<width>108</width>
<height>96</height>
<sql_create_table>CREATE TABLE `topics_heroes` (
  `TOPIC_ID` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `HERO_ID` int(11) NOT NULL,
  KEY `TOPIC_ID` (`TOPIC_ID`),
  KEY `HERO_ID` (`HERO_ID`),
  CONSTRAINT `topics_heroes_ibfk_1` FOREIGN KEY (`TOPIC_ID`) REFERENCES `topic` (`id`),
  CONSTRAINT `topics_heroes_ibfk_2` FOREIGN KEY (`HERO_ID`) REFERENCES `hero` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="news" view="colnames">
<left>556</left>
<top>826</top>
<width>122</width>
<height>96</height>
<sql_create_table>CREATE TABLE `news` (
  `TOPIC_ID` int(11) NOT NULL,
  `pass_to_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  KEY `TOPIC_ID` (`TOPIC_ID`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`TOPIC_ID`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="simple_forum_topic" view="colnames">
<left>693</left>
<top>873</top>
<width>143</width>
<height>96</height>
<sql_create_table>CREATE TABLE `simple_forum_topic` (
  `TOPIC_ID` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `GLOBAL_FORUM_TOPIC_ID` int(11) NOT NULL,
  KEY `TOPIC_ID` (`TOPIC_ID`),
  KEY `GLOBAL_FORUM_TOPIC` (`GLOBAL_FORUM_TOPIC_ID`),
  CONSTRAINT `simple_forum_topic_ibfk_1` FOREIGN KEY (`TOPIC_ID`) REFERENCES `topic` (`id`),
  CONSTRAINT `simple_forum_topic_ibfk_2` FOREIGN KEY (`GLOBAL_FORUM_TOPIC_ID`) REFERENCES `global_forum_topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="forum_post" view="colnames">
<left>1046</left>
<top>1013</top>
<width>180</width>
<height>112</height>
<sql_create_table>CREATE TABLE `forum_post` (
  `MESSAGE_ID` int(11) NOT NULL,
  `likes` int(11) DEFAULT '0',
  `SIMPLE_FORUM_TOPIC_ID` int(11) NOT NULL,
  KEY `MESSAGE_ID` (`MESSAGE_ID`),
  KEY `SIMPLE_FORUM_TOPIC_ID` (`SIMPLE_FORUM_TOPIC_ID`),
  CONSTRAINT `forum_post_ibfk_1` FOREIGN KEY (`MESSAGE_ID`) REFERENCES `message` (`id`),
  CONSTRAINT `forum_post_ibfk_2` FOREIGN KEY (`SIMPLE_FORUM_TOPIC_ID`) REFERENCES `simple_forum_topic` (`TOPIC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
<table name="global_forum_topic" view="colnames">
<left>292</left>
<top>1026</top>
<width>116</width>
<height>96</height>
<sql_create_table>CREATE TABLE `global_forum_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin</sql_create_table>
</table>
</tables>
</canvas>
</schemadesigner>