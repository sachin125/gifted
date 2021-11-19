create database if not exists `gifted`;
USE `gifted`;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

DROP TABLE IF EXISTS `contactinformation`;

CREATE TABLE `contactinformation` (
  `name` varchar(45) default NULL,
  `emailid` varchar(45) NOT NULL,
  `subject` varchar(45) default NULL,
  `message` varchar(1000) default NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


insert  into `contactinformation`(`name`,`emailid`,`subject`,`message`) values (NULL,'',NULL,NULL),('shruti porwal','shrutiporwal@gmail.com','hello','hello bhavya'),('asdjh','jhsj@gmail.com','jh','jh'),(NULL,'jnj','jkln','klml'),('Mr. Lalsingh Chouhan','paliwa@gmail.vom','hello','New Message from my sidw'),('bennet','bennet@gmail.com','hello','hello'),('bhavya','bhavya@gmail.com','hello','hello'),('Tarun Purohit','tarun@gmail.com','Query','hiii this is me');

DROP TABLE IF EXISTS `login`;

/*!50001 DROP VIEW IF EXISTS `login` */;
/*!50001 DROP TABLE IF EXISTS `login` */;

/*!50001 CREATE TABLE `login` (
  `emailid` varchar(45) NOT NULL default '',
  `password` varchar(45) NOT NULL default '',
  `ul` varchar(10) NOT NULL default ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1 */;


DROP TABLE IF EXISTS `registration`;

CREATE TABLE `registration` (
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `emailid` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `dob` varchar(45) NOT NULL,
  `reg_date` bigint(20) NOT NULL,
  `ul` varchar(10) NOT NULL,
  `reg_verified` enum('verified','unverified') NOT NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert  into `registration`(`fname`,`lname`,`emailid`,`password`,`gender`,`dob`,`reg_date`,`ul`,`reg_verified`) values 
('Admin','','admin@ds.com','admin','MALE','',1430218086801,'admin','verified'),
('shruti','porwal','shruti@gmail.com','12345','FEMALE','08/08/1999',1430218086801,'user','verified'),
('bhavya','bhavya','bhavya@gmail.com','12345','FEMALE','12/05/1999',1430218086801,'user','verified');

DROP TABLE IF EXISTS `transfer`;

CREATE TABLE `transfer` (
  `sender` varchar(45) default NULL,
  `receiver` varchar(45) default NULL,
  `subject` varchar(45) default NULL,
  `emailname` varchar(45) default NULL,
  `filename` varchar(45) default NULL,
  `time` bigint(20) default NULL,
  `email_signature` varchar(45) default NULL,
  `publickey` varchar(45) default NULL,
  `file_signature` varchar(45) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


insert  into `transfer`(`sender`,`receiver`,`subject`,`emailname`,`filename`,`time`,`email_signature`,`publickey`,`file_signature`) values ('shrutiporwal@gmail.com','bhavya@gmail.com','hello','1430218218461.txt.enc','1430218218461.gif.enc',1430218218461,'1430218218461.txt','1430218218465Public.key','1430218218461.txt'),('bhavya@gmail.com','shrutiporwal@gmail.com','hello','1430218365619.txt.enc','1430218365619.gif.enc',1430218365619,'1430218365619.txt','1430218218465Public.key','1430218365619.txt'),('bhavya@gmail.com','bennet@gmail.com','hello','1430996471806.txt.enc',NULL,1430996471806,'1430996471806.txt','1430996471823Public.key',NULL),('bhavya@gmail.com','bennet@gmail.com','hello','1431076963467.txt.enc','1431076963467.ppt.enc',1431076963467,'1431076963467.txt','1431076963483Public.key','1431076963467.txt'),('bhavya@gmail.com','shrutiporwal@gmail.com','hello','1431099557899.txt.enc','1431099557899.gif.enc',1431099557899,'1431099557899.txt','1431099557915Public.key','1431099557899.txt'),('shrutiporwal@gmail.com','bhavya@gmail.com','bennet','1431157977544.txt.enc','1431157977544.gif.enc',1431157977544,'1431157977544.txt','1431157977560Public.key','1431157977544.txt'),('shrutiporwal@gmail.com','bhavya@gmail.com','bennet','1431158705174.txt.enc','1431158705174.jpg.enc',1431158705174,'1431158705174.txt','1431157977560Public.key','1431158705174.txt'),('shrutiporwal@gmail.com','bhavya@gmail.com','Admin ','1431159812034.txt.enc','1431159812034.gif.enc',1431159812034,'1431159812034.txt','1431159812034Public.key','1431159812034.txt'),('bhavya@gmail.com','bennet@gmail.com','hiudfiud','1432797935278.txt.enc','1432797935278.key.enc',1432797935278,'1432797935278.txt','1432797935297Public.key','1432797935278.txt'),('shrutiporwal@gmail.com','bennet@gmail.com','hello','1432875092016.txt.enc','1432875092016.gif.enc',1432875092016,'1432875092016.txt','1432875092032Public.key','1432875092016.txt');



/*!50001 DROP TABLE IF EXISTS `login` */;
/*!50001 DROP VIEW IF EXISTS `login` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `login` AS select `registration`.`emailid` AS `emailid`,`registration`.`password` AS `password`,`registration`.`ul` AS `ul` from `registration` where (`registration`.`reg_verified` = _latin1'verified') */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
