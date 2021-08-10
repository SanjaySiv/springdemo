-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: car_rental
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cardates`
--

DROP TABLE IF EXISTS `cardates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardates` (
  `carId` int NOT NULL,
  `bookingDate` varchar(45) NOT NULL,
  `returnDate` varchar(45) NOT NULL,
  `userId` int NOT NULL,
  `rentAmount` int NOT NULL,
  `dealerId` int NOT NULL,
  KEY `carId_idx` (`carId`),
  KEY `dealerId_idx` (`dealerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardates`
--

LOCK TABLES `cardates` WRITE;
/*!40000 ALTER TABLE `cardates` DISABLE KEYS */;
INSERT INTO `cardates` VALUES (6,'2021-05-25','2021-05-29',11,0,0),(6,'2021-05-30','2021-06-02',11,3000,0),(10,'2021-05-31','2021-06-03',11,2100,0),(10,'2021-06-11','2021-06-13',11,1800,0),(10,'2021-06-14','2021-06-15',11,900,0),(10,'2021-06-18','2021-06-20',11,1800,0),(10,'2021-06-21','2021-06-23',11,1800,0),(10,'2021-06-24','2021-06-25',11,900,0),(10,'2021-06-29','2021-06-29',11,0,0),(10,'2021-07-01','2021-07-02',11,900,0),(10,'2021-07-03','2021-07-04',11,900,0),(12,'2021-07-01','2021-07-03',12,1800,0),(11,'2021-07-01','2021-07-03',13,2000,0),(10,'2021-07-06','2021-07-07',12,900,0),(12,'2021-07-15','2021-07-16',12,900,0),(10,'2021-07-10','2021-07-11',13,900,0),(12,'2021-07-20','2021-07-21',13,900,0),(10,'2021-07-15','2021-07-16',12,900,0),(12,'2021-07-23','2021-07-24',13,900,0),(11,'2021-07-08','2021-07-10',11,3000,0),(11,'2021-07-13','2021-07-14',11,2000,0),(10,'2021-07-31','2021-08-01',11,1800,0),(10,'2021-08-03','2021-08-05',11,2250,0),(14,'2021-08-03','2021-08-04',11,2000,0),(14,'2021-07-17','2021-07-19',33,3000,0),(13,'2021-07-22','2021-07-25',12,1600,0),(13,'2021-07-27','2021-07-28',13,800,0),(11,'2021-08-06','2021-08-07',11,2000,0),(25,'2021-07-29','2021-07-30',11,1680,0),(26,'2021-07-31','2021-08-01',11,800,53),(26,'2021-08-03','2021-08-04',11,800,53),(28,'2021-07-22','2021-07-23',12,2000,54),(25,'2021-07-21','2021-07-22',13,1680,53),(24,'2021-07-18','2021-07-19',13,1400,51),(29,'2021-07-28','2021-07-29',11,1800,55),(25,'2021-08-06','2021-08-08',11,2520,53);
/*!40000 ALTER TABLE `cardates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `carId` int NOT NULL AUTO_INCREMENT,
  `model` varchar(45) DEFAULT NULL,
  `seat` int DEFAULT NULL,
  `regNo` varchar(45) DEFAULT NULL,
  `permit` varchar(45) DEFAULT NULL,
  `rent` int NOT NULL,
  `location` varchar(45) NOT NULL,
  `dealerId` int DEFAULT NULL,
  PRIMARY KEY (`carId`),
  UNIQUE KEY `regNo` (`regNo`),
  KEY `userId_idx` (`dealerId`),
  CONSTRAINT `userId` FOREIGN KEY (`dealerId`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (22,'Innova',7,'KL 01 AH 7854','All India',700,'trivandrum',51),(24,'Wagonr',5,'KL 01 AF 4521','All Kerala',900,'trivandrum',51),(25,'Swift',5,'KL 01 CD 6523','All Kerala',840,'kollam',53),(26,'Alto',5,'KL 01 BC 9815','All Kerala',400,'kollam',53),(27,'Compass',7,'KL 01 AF 0012','All India',1000,'malappuram',54),(28,'Honda city',5,'KL 10 6983','All India',900,'malappuram',54);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (11,'sanjay','palakkad','9876543210','sanjay@sample.com','sanjay','qwert','customer'),(12,'Subin','Malappuram','9876512309','subin@sample.com','subin','qwert','customer'),(13,'Mathew','Kollam','8712356875','mathew@sample.com','mathew','qwert','customer'),(20,'anil','Kollam','7822456522','anil@sample.com','anil','anil','customer'),(28,'admin','Address','1234567890','admin@admin.com','admin','admin','employee'),(33,'avees','Address','6756423','avees','avees','avees','customer'),(48,'sanjay','Address','7012345987','sanjay@admin.com','sanjayadmin','sanjay','employee'),(51,'sanjay','palakkad','876584423','sanjay@dealer.com','sanjaydealer','sanjay','dealer'),(53,'Any car','Kollam','6742321546','anycar@sample.com','anycar','anycar','dealer'),(54,'Motor hub','Malappuram','9454123456','motorhub@sample.com','motorhub','motor','dealer'),(55,'Auto Mart','palakkad','9235676322','automart@dealer.com','automart','automart','dealer'),(63,'sam','palakkad','1234567','sam@sample.com','sam','sam','customer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-10 12:10:21
