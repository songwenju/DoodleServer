/*
SQLyog v10.2 
MySQL - 5.1.73-community : Database - doodle
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`doodle` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `doodle`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `userEmail` varchar(40) NOT NULL,
  `userPassword` varchar(60) NOT NULL,
  `checkCode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`userEmail`,`userPassword`,`checkCode`) values (1,'swj','songwenju@outlook.com','123','null'),(2,'swj','songwenju@outlook.com','123','null'),(3,'swj','songwenju@outlook.com','123','null'),(4,'swj','songwenju@outlook.com','123','null'),(5,'swj','songwenju@outlook.com','123','null'),(6,'swj','songwenju@outlook.com','123','null'),(7,'swj','songwenju@outlook.com','123','null'),(8,'swj','songwenju@outlook.com','123','null'),(9,'swj','songwenju@outlook.com','123','null'),(10,'swj','songwenju@outlook.com','123','null'),(11,'swj','songwenju@outlook.com','123','null'),(12,'swj','songwenju@outlook.com','123','null'),(13,'swj','songwenju@outlook.com','123','null'),(14,'swj','songwenju@outlook.com','123','null'),(15,'swj','songwenju@outlook.com','123','null'),(16,'swj','songwenju@outlook.com','123','null'),(17,'swj','songwenju@outlook.com','123','null'),(18,'swj','songwenju@outlook.com','123','null'),(19,'swj','songwenju@outlook.com','123','null'),(20,'swj','1565270590@qq.com','123','null');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
