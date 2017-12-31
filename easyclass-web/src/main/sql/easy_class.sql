-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: easy_class
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `easy_class`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `easy_class` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easy_class`;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `attendanceId` int(11) NOT NULL,
  `attend` bit(1) NOT NULL,
  `closed` bit(1) NOT NULL,
  `closedTime` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `establishedTime` datetime DEFAULT NULL,
  `arrangeId` int(11) DEFAULT NULL,
  `codeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`attendanceId`),
  KEY `FKrb4j77uyobby5ujoohjvst45l` (`arrangeId`),
  KEY `FKh8c82ntbfw10n8xv332frlmkx` (`codeId`),
  CONSTRAINT `FKh8c82ntbfw10n8xv332frlmkx` FOREIGN KEY (`codeId`) REFERENCES `q_rcode` (`codeId`),
  CONSTRAINT `FKrb4j77uyobby5ujoohjvst45l` FOREIGN KEY (`arrangeId`) REFERENCES `teacher_arrangement` (`arrangementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,'','\0',NULL,'2018-01-01 15:20:36','2017-12-30 16:20:15',1,NULL),(2,'','\0',NULL,'2018-01-01 16:20:52','2017-12-30 16:20:18',2,NULL),(3,'','\0',NULL,'2018-01-01 16:21:01','2017-12-30 16:20:20',3,NULL),(4,'','\0',NULL,'2018-01-01 16:21:05','2017-12-30 16:20:24',4,NULL),(5,'','\0',NULL,'2018-01-01 16:21:10','2017-12-30 16:20:26',5,NULL),(6,'','\0',NULL,'2018-01-01 16:21:15','2017-12-30 16:20:29',6,NULL),(7,'','\0','2017-12-30 16:23:32','2018-01-01 16:21:21','2017-12-30 16:20:32',7,NULL),(8,'','\0','2017-12-30 16:23:27','2017-12-31 16:23:01','2017-12-30 16:22:55',8,NULL);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_schedule`
--

DROP TABLE IF EXISTS `class_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_schedule` (
  `scheduleId` int(11) NOT NULL,
  `commentId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `arrangeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`scheduleId`),
  KEY `FK4w4f90q4kfumoi96q312d8bhe` (`commentId`),
  KEY `FKtcj13gj61l4po6xmxr7vj2n23` (`userId`),
  KEY `FKm1tk8b0cxgxdryam2hy9vybl8` (`arrangeId`),
  CONSTRAINT `FK4w4f90q4kfumoi96q312d8bhe` FOREIGN KEY (`commentId`) REFERENCES `teaching_comment` (`commentId`),
  CONSTRAINT `FKm1tk8b0cxgxdryam2hy9vybl8` FOREIGN KEY (`arrangeId`) REFERENCES `teacher_arrangement` (`arrangementId`),
  CONSTRAINT `FKtcj13gj61l4po6xmxr7vj2n23` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_schedule`
--

LOCK TABLES `class_schedule` WRITE;
/*!40000 ALTER TABLE `class_schedule` DISABLE KEYS */;
INSERT INTO `class_schedule` VALUES (1,1,10,1),(2,2,11,1),(3,26,20,1),(4,4,12,1),(5,5,13,1),(6,6,14,1),(7,7,15,1),(8,8,16,1),(9,9,17,1),(10,10,18,1),(11,11,19,1);
/*!40000 ALTER TABLE `class_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_time`
--

DROP TABLE IF EXISTS `class_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_time` (
  `timeId` int(11) NOT NULL,
  `classOrder` varchar(255) DEFAULT NULL,
  `term` varchar(255) DEFAULT NULL,
  `week` varchar(255) DEFAULT NULL,
  `weekday` varchar(255) DEFAULT NULL,
  `arrangementId` int(11) DEFAULT NULL,
  PRIMARY KEY (`timeId`),
  KEY `FK9cepgyf9000o43oep01h1qqxk` (`arrangementId`),
  CONSTRAINT `FK9cepgyf9000o43oep01h1qqxk` FOREIGN KEY (`arrangementId`) REFERENCES `teacher_arrangement` (`arrangementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_time`
--

LOCK TABLES `class_time` WRITE;
/*!40000 ALTER TABLE `class_time` DISABLE KEYS */;
INSERT INTO `class_time` VALUES (1,'1','2018','1','1',1),(2,'1','2018','2','1',1),(3,'1','2018','3','1',1),(4,'1','2018','4','1',1),(5,'1','2018','5','1',1),(6,'1','2018','6','1',1),(7,'1','2018','7','1',1),(8,'3','2018','1','3',1),(9,'3','2018','2','3',1),(10,'3','2018','3','3',1),(11,'3','2018','4','3',1),(12,'3','2018','6','3',1),(13,'3','2018','7','3',1),(14,'3','2018','5','3',1);
/*!40000 ALTER TABLE `class_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `credit` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'常识',6,'必修课'),(2,'大学物理',3,'必修课'),(3,'高等数学',6,'必修课'),(4,'诗词鉴赏',2,'选修课'),(5,'社交礼仪',1.5,'选修课'),(6,'定向越野',1.5,'选修课'),(7,'多彩的生物世界',1.5,'选修课'),(8,'工程制图',2,'必修课'),(9,'模拟电子线路',3,'必修课'),(10,'马克思主义基本原理',3,'必修课'),(11,'程序设计基础1',4,'必修课'),(12,'程序设计基础2',2,'必修课'),(13,'flash',2,'通识选修课'),(14,'C++程序设计',2,'必修课'),(15,'java程序设计',2,'必修课'),(16,'j2ee程序设计',2,'必修课');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courseware`
--

DROP TABLE IF EXISTS `courseware`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courseware` (
  `coursewareId` int(11) NOT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `size` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `arrangementId` int(11) DEFAULT NULL,
  PRIMARY KEY (`coursewareId`),
  KEY `FKklw2gj1kkigxtqwwqxv3wipsb` (`arrangementId`),
  CONSTRAINT `FKklw2gj1kkigxtqwwqxv3wipsb` FOREIGN KEY (`arrangementId`) REFERENCES `teacher_arrangement` (`arrangementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseware`
--

LOCK TABLES `courseware` WRITE;
/*!40000 ALTER TABLE `courseware` DISABLE KEYS */;
/*!40000 ALTER TABLE `courseware` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `depId` int(11) NOT NULL,
  `depName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homework`
--

DROP TABLE IF EXISTS `homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homework` (
  `homeworkId` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `establishedTime` datetime DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `submitted` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `scheduleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`homeworkId`),
  KEY `FK9hnhh559r5sx4klsnswg7avio` (`scheduleId`),
  CONSTRAINT `FK9hnhh559r5sx4klsnswg7avio` FOREIGN KEY (`scheduleId`) REFERENCES `class_schedule` (`scheduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework`
--

LOCK TABLES `homework` WRITE;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `noticeId` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `establishedTime` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `arrangeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`noticeId`),
  KEY `FKq07fj1wri2w96bjhovpd76kyp` (`arrangeId`),
  CONSTRAINT `FKq07fj1wri2w96bjhovpd76kyp` FOREIGN KEY (`arrangeId`) REFERENCES `teacher_arrangement` (`arrangementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'第21周考试','2017-12-30 16:24:49','考试安排',1),(2,'第3周交第一次实验报告','2017-12-30 16:28:18','第1次实验通知',1),(3,'第5周交第2次实验报告','2017-12-30 16:28:37','第2次实验通知',1),(4,'第7周交第3次实验报告','2017-12-30 16:28:46','第3次实验通知',1),(5,'第9周交第4次实验报告','2017-12-30 16:28:56','第4次实验通知',1),(6,'第10周交第5次实验报告','2017-12-30 16:29:05','第5次实验通知',1);
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `online_class_test`
--

DROP TABLE IF EXISTS `online_class_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `online_class_test` (
  `testId` int(11) NOT NULL,
  `deadline` datetime DEFAULT NULL,
  `establishedTime` datetime DEFAULT NULL,
  `arrangeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`testId`),
  KEY `FK4707qj9xc6gxdgusnn715odup` (`arrangeId`),
  CONSTRAINT `FK4707qj9xc6gxdgusnn715odup` FOREIGN KEY (`arrangeId`) REFERENCES `teacher_arrangement` (`arrangementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `online_class_test`
--

LOCK TABLES `online_class_test` WRITE;
/*!40000 ALTER TABLE `online_class_test` DISABLE KEYS */;
INSERT INTO `online_class_test` VALUES (1,'2018-01-01 15:47:09','2017-12-30 15:47:22',1),(2,'2017-12-31 20:09:22','2017-12-31 18:08:45',1),(3,'2018-01-02 21:09:30','2018-01-02 18:08:55',1);
/*!40000 ALTER TABLE `online_class_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `q_rcode`
--

DROP TABLE IF EXISTS `q_rcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `q_rcode` (
  `codeId` int(11) NOT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `q_rcode`
--

LOCK TABLES `q_rcode` WRITE;
/*!40000 ALTER TABLE `q_rcode` DISABLE KEYS */;
/*!40000 ALTER TABLE `q_rcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `questionId` int(11) NOT NULL,
  `answerOrder` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`questionId`),
  KEY `FK9sui8laudydw48v5hbxyrpfkv` (`courseId`),
  CONSTRAINT `FK9sui8laudydw48v5hbxyrpfkv` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,1,'G轴中最轻的轴体是？',1),(4,3,'以下G轴中最重的轴体',1),(5,1,'英语四六级通过的分数',1),(6,2,'天空的颜色',1),(7,2,'大学期末的时候人口最密集的地方是哪？',1),(8,2,'准确来说每周的第一天应该是周几',1),(9,2,'R5 1600x的规格',1),(10,1,'i7 7700k的规格',1),(11,2,'i5 8400的规格',1),(12,2,'现在最新版本的内存条是',1),(13,1,'英国的英文缩写是',1);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_option`
--

DROP TABLE IF EXISTS `question_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_option` (
  `optionId` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `optionOrder` int(11) DEFAULT NULL,
  `questionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`optionId`),
  KEY `FK2jpltvrgtlud0919ftwdir85` (`questionId`),
  CONSTRAINT `FK2jpltvrgtlud0919ftwdir85` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_option`
--

LOCK TABLES `question_option` WRITE;
/*!40000 ALTER TABLE `question_option` DISABLE KEYS */;
INSERT INTO `question_option` VALUES (1,'绿轴',1,1),(2,'青轴',2,1),(6,'绿轴',3,4),(7,'红轴',2,4),(8,'黑轴',1,4),(9,'425',1,5),(10,'600',2,5),(11,'白色的',1,6),(12,'看情况',2,6),(13,'教室',1,7),(14,'图书馆',2,7),(15,'周日',1,8),(16,'周一',2,8),(17,'四核八线程',1,9),(18,'六核十二线程',2,9),(19,'六核十二线程',2,10),(20,'四核八线程',1,10),(21,'四核八线程',1,11),(22,'六核六线程',2,11),(23,'ddr4',2,12),(24,'ddr3',1,12),(25,'US',2,13),(26,'UK',1,13);
/*!40000 ALTER TABLE `question_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sign_record`
--

DROP TABLE IF EXISTS `sign_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sign_record` (
  `signId` int(11) NOT NULL,
  `signTime` datetime DEFAULT NULL,
  `attendanceId` int(11) DEFAULT NULL,
  `scheduleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`signId`),
  KEY `FKscbqdm82x1s6a8u9ksrpqk49g` (`attendanceId`),
  KEY `FKf81ucmw0w5acwmb7g5lgi9ulm` (`scheduleId`),
  CONSTRAINT `FKf81ucmw0w5acwmb7g5lgi9ulm` FOREIGN KEY (`scheduleId`) REFERENCES `class_schedule` (`scheduleId`),
  CONSTRAINT `FKscbqdm82x1s6a8u9ksrpqk49g` FOREIGN KEY (`attendanceId`) REFERENCES `attendance` (`attendanceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sign_record`
--

LOCK TABLES `sign_record` WRITE;
/*!40000 ALTER TABLE `sign_record` DISABLE KEYS */;
INSERT INTO `sign_record` VALUES (1,'2017-12-30 07:54:00',1,1),(2,'2017-12-30 07:54:00',1,2),(4,'2017-12-30 07:54:00',1,4),(5,'2017-12-30 07:54:00',1,5),(6,'2017-12-30 07:54:00',1,6),(7,'2017-12-30 07:54:00',1,7),(8,'2017-12-30 07:54:00',1,8),(9,'2017-12-30 07:54:00',1,9),(10,'2017-12-30 07:54:00',1,10),(11,'2017-12-30 07:54:00',1,11);
/*!40000 ALTER TABLE `sign_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_arrangement`
--

DROP TABLE IF EXISTS `teacher_arrangement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_arrangement` (
  `arrangementId` int(11) NOT NULL,
  `place` varchar(255) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`arrangementId`),
  KEY `FKf3fv8aqs68130jfxrdadjh91m` (`courseId`),
  KEY `FKta3aeyhh63f131irbi0csxcpi` (`userId`),
  CONSTRAINT `FKf3fv8aqs68130jfxrdadjh91m` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `FKta3aeyhh63f131irbi0csxcpi` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_arrangement`
--

LOCK TABLES `teacher_arrangement` WRITE;
/*!40000 ALTER TABLE `teacher_arrangement` DISABLE KEYS */;
INSERT INTO `teacher_arrangement` VALUES (1,'一工101',1,1),(2,'一工101',2,2),(3,'一工102',2,3),(4,'一工103',3,3),(5,'一工104',4,4),(6,'一工105',5,5),(7,'一工106',6,6),(8,'一工107',6,7),(9,'四工A101',1,1),(10,'四工A102',2,2);
/*!40000 ALTER TABLE `teacher_arrangement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching_comment`
--

DROP TABLE IF EXISTS `teaching_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teaching_comment` (
  `commentLevel` varchar(31) NOT NULL,
  `commentId` int(11) NOT NULL,
  `score` float NOT NULL,
  `arrangementId` int(11) DEFAULT NULL,
  `scheduleId` int(11) DEFAULT NULL,
  `timeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `FKgg3yio106ka3go9tdgx0mmxrx` (`arrangementId`),
  KEY `FK4donkkbnsxflccqpfxiatipd3` (`scheduleId`),
  KEY `FKkmol10c2qxxlkomhy6yrkgcdh` (`timeId`),
  CONSTRAINT `FK4donkkbnsxflccqpfxiatipd3` FOREIGN KEY (`scheduleId`) REFERENCES `class_schedule` (`scheduleId`),
  CONSTRAINT `FKgg3yio106ka3go9tdgx0mmxrx` FOREIGN KEY (`arrangementId`) REFERENCES `teacher_arrangement` (`arrangementId`),
  CONSTRAINT `FKkmol10c2qxxlkomhy6yrkgcdh` FOREIGN KEY (`timeId`) REFERENCES `class_time` (`timeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching_comment`
--

LOCK TABLES `teaching_comment` WRITE;
/*!40000 ALTER TABLE `teaching_comment` DISABLE KEYS */;
INSERT INTO `teaching_comment` VALUES ('Course',1,100,1,1,NULL),('Course',2,99,1,2,NULL),('Course',4,98,1,4,NULL),('Course',5,100,1,6,NULL),('Course',6,95,1,6,NULL),('Course',7,95,1,7,NULL),('Course',8,95,1,8,NULL),('Course',9,95,1,9,NULL),('Course',10,95,1,10,NULL),('Course',11,95,1,11,NULL),('Class',12,100,NULL,1,1),('Class',13,100,NULL,1,2),('Class',14,100,NULL,1,3),('Class',15,100,NULL,1,4),('Class',16,100,NULL,1,5),('Class',17,100,NULL,1,6),('Class',18,100,NULL,1,7),('Class',19,100,NULL,1,8),('Class',20,100,NULL,1,9),('Class',21,100,NULL,1,10),('Class',22,100,NULL,1,11),('Class',23,100,NULL,1,12),('Class',24,90,NULL,1,13),('Class',25,99,NULL,1,14),('Course',26,95,1,3,NULL);
/*!40000 ALTER TABLE `teaching_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_question`
--

DROP TABLE IF EXISTS `test_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_question` (
  `testId` int(11) NOT NULL,
  `questionId` int(11) NOT NULL,
  KEY `FKpg6xsbl52lp54y9vl23o0i65o` (`questionId`),
  KEY `FK7o6i671bgwvpxnkjdjbd8mvs9` (`testId`),
  CONSTRAINT `FK7o6i671bgwvpxnkjdjbd8mvs9` FOREIGN KEY (`testId`) REFERENCES `online_class_test` (`testId`),
  CONSTRAINT `FKpg6xsbl52lp54y9vl23o0i65o` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_question`
--

LOCK TABLES `test_question` WRITE;
/*!40000 ALTER TABLE `test_question` DISABLE KEYS */;
INSERT INTO `test_question` VALUES (1,4),(1,1),(1,5),(1,6),(1,7),(2,6),(2,7),(2,8),(2,9),(2,10),(3,7),(3,8),(3,6),(3,11),(3,10);
/*!40000 ALTER TABLE `test_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_record`
--

DROP TABLE IF EXISTS `test_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_record` (
  `recordId` int(11) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `score` float NOT NULL,
  `scheduleId` int(11) DEFAULT NULL,
  `testId` int(11) DEFAULT NULL,
  PRIMARY KEY (`recordId`),
  KEY `FKn6mjtcr9kikm5m7q0a98dm2ok` (`scheduleId`),
  KEY `FK3qe737598d75efnto8a7s5eqf` (`testId`),
  CONSTRAINT `FK3qe737598d75efnto8a7s5eqf` FOREIGN KEY (`testId`) REFERENCES `online_class_test` (`testId`),
  CONSTRAINT `FKn6mjtcr9kikm5m7q0a98dm2ok` FOREIGN KEY (`scheduleId`) REFERENCES `class_schedule` (`scheduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_record`
--

LOCK TABLES `test_record` WRITE;
/*!40000 ALTER TABLE `test_record` DISABLE KEYS */;
INSERT INTO `test_record` VALUES (1,'1,1,2,1,2',80,1,1),(2,'1,1,2,1,2',80,2,1),(3,'1,1,2,2,2',100,4,1),(4,'2,2,1,2,2',100,6,1),(5,'2,2,1,1,2',100,5,1),(6,'2,2,1,1,2',100,3,1),(7,'2,2,1,1,2',100,1,2),(8,'2,2,1,1,2',100,2,2),(9,'2,2,1,1,2',100,3,2),(10,'2,2,1,1,2',100,4,2),(11,'2,2,1,1,2',100,5,2),(12,'2,2,1,1,2',100,1,3),(13,'2,2,1,1,2',100,2,3),(14,'2,2,1,1,2',100,3,3),(15,'2,2,1,1,2',100,4,3),(16,'2,2,1,1,2',100,5,3);
/*!40000 ALTER TABLE `test_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `serviceLevel` varchar(31) NOT NULL,
  `userId` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `teacherGender` varchar(255) DEFAULT NULL,
  `teacherId` varchar(255) DEFAULT NULL,
  `teacherName` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `majorIn` varchar(255) DEFAULT NULL,
  `studentGender` varchar(255) DEFAULT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `depId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UK_cmubifvnahuydie5hkyft79fp` (`teacherId`),
  UNIQUE KEY `UK_5m7f6sv2emosxheqxkcadascf` (`studentId`),
  KEY `FK740kgr69n4541atao2lwbah4g` (`depId`),
  CONSTRAINT `FK740kgr69n4541atao2lwbah4g` FOREIGN KEY (`depId`) REFERENCES `department` (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Teacher',1,'123','123456老师','男','123456','赵刚',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',2,'123','123457老师','女','123457','李艳',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',3,'123','123455老师','女','123455','王晓玲',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',4,'123','123454老师','男','123454','刘少君',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',5,'123','123453老师','男','123453','孙振',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',6,'123','123452老师','男','123452','张罗森',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',7,'123','123451老师','男','123451','张嘟嘟',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',8,'123','123458老师','女','123458','罗森',NULL,NULL,NULL,NULL,NULL,NULL),('Teacher',9,'123','123459老师','女','123459','丁丹',NULL,NULL,NULL,NULL,NULL,NULL),('Student',10,'123','0000',NULL,NULL,NULL,'2015','软件工程','男','935100000000','小明',NULL),('Student',11,'123','0001',NULL,NULL,NULL,'2015','软件工程','男','935100000001','小卡',NULL),('Student',12,'123','0002',NULL,NULL,NULL,'2015','软件工程','男','935100000002','小芳',NULL),('Student',13,'123','0003',NULL,NULL,NULL,'2015','软件工程','男','935100000003','小刘',NULL),('Student',14,'123','0004',NULL,NULL,NULL,'2015','软件工程','男','935100000004','小张',NULL),('Student',15,'123','0005',NULL,NULL,NULL,'2015','软件工程','男','935100000005','萌萌',NULL),('Student',16,'123','0006',NULL,NULL,NULL,'2015','软件工程','男','935100000006','小祥',NULL),('Student',17,'123','0007',NULL,NULL,NULL,'2015','软件工程','男','935100000007','小远',NULL),('Student',18,'123','0008',NULL,NULL,NULL,'2015','软件工程','男','935100000008','小欧',NULL),('Student',19,'123','0009',NULL,NULL,NULL,'2015','软件工程','男','935100000009','小光',NULL),('Student',20,'123','0010',NULL,NULL,NULL,'2015','软件工程','男','935100000010','小帆',NULL),('Student',21,'123','0011',NULL,NULL,NULL,'2015','软件工程','男','935100000011','小德',NULL),('Student',22,'123','0012',NULL,NULL,NULL,'2015','软件工程','男','935100000012','小王',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `voteId` int(11) NOT NULL,
  `closed` bit(1) NOT NULL,
  `deadline` datetime DEFAULT NULL,
  `establishedTime` datetime DEFAULT NULL,
  `voteContent` varchar(255) DEFAULT NULL,
  `attendanceId` int(11) DEFAULT NULL,
  PRIMARY KEY (`voteId`),
  KEY `FKgmrafi0wpj25jqxphpfu3aku1` (`attendanceId`),
  CONSTRAINT `FKgmrafi0wpj25jqxphpfu3aku1` FOREIGN KEY (`attendanceId`) REFERENCES `attendance` (`attendanceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES (1,'\0',NULL,'2017-12-30 17:38:52','这里懂了吗',1),(2,'\0',NULL,'2017-12-30 17:39:46','需要再讲一遍这部分吗？',1),(3,'\0',NULL,'2017-12-30 17:49:26','希望本门课程考试还是考察？',1);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_option`
--

DROP TABLE IF EXISTS `vote_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_option` (
  `voteOptionId` int(11) NOT NULL,
  `optionContent` varchar(255) DEFAULT NULL,
  `optionCount` int(11) DEFAULT NULL,
  `voteId` int(11) DEFAULT NULL,
  PRIMARY KEY (`voteOptionId`),
  KEY `FKt0t23mnf3nrha702k98q8bahr` (`voteId`),
  CONSTRAINT `FKt0t23mnf3nrha702k98q8bahr` FOREIGN KEY (`voteId`) REFERENCES `vote` (`voteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_option`
--

LOCK TABLES `vote_option` WRITE;
/*!40000 ALTER TABLE `vote_option` DISABLE KEYS */;
INSERT INTO `vote_option` VALUES (1,'不懂',0,1),(2,'懂',0,1),(3,'不需要',0,2),(4,'需要',0,2),(5,'考察',0,3),(6,'考试',0,3);
/*!40000 ALTER TABLE `vote_option` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-31 17:06:35
