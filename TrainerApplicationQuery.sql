-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: fitness_tracker
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity_type`
--

DROP TABLE IF EXISTS `activity_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_type` (
  `activity_type_id` int NOT NULL AUTO_INCREMENT,
  `activity_type` varchar(150) NOT NULL,
  PRIMARY KEY (`activity_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_type`
--

LOCK TABLES `activity_type` WRITE;
/*!40000 ALTER TABLE `activity_type` DISABLE KEYS */;
INSERT INTO `activity_type` VALUES (1,'Running,Yoga'),(2,'Yoga,Cycling'),(3,'Cycling,Swimming'),(4,'Swimming,Weightlifting'),(5,'Running,Cycling');
/*!40000 ALTER TABLE `activity_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL,
  `city_name` varchar(25) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'New York'),(2,'Los Angeles'),(3,'Toronto'),(4,'London'),(5,'Manchester'),(6,'Chennai'),(7,'Dindugal'),(30,'Chennai');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `country_id` int NOT NULL,
  `country_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'United States'),(2,'Canada'),(3,'United Kingdom'),(6,'India');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `customer_dob` date NOT NULL,
  `customer_weight` decimal(38,2) DEFAULT NULL,
  `customer_height` decimal(38,2) DEFAULT NULL,
  `customer_bmi` decimal(38,2) DEFAULT NULL,
  `customer_street` varchar(50) NOT NULL,
  `city_id` int NOT NULL,
  `state_id` int NOT NULL,
  `country_id` int NOT NULL,
  `customer_number` varchar(20) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `city_id` (`city_id`),
  KEY `state_id` (`state_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`),
  CONSTRAINT `customer_ibfk_3` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (101,'Micheal','2002-05-20',63.70,168.00,22.60,'456 Birch St',3,2,1,'444-777-8888'),(102,'Daniel','1996-04-07',80.50,175.50,26.10,'123 Oak St',5,1,3,'123-234-5678'),(103,'Sophia','1990-12-24',58.20,160.00,22.70,'789 Cedar St',1,3,2,'777-555-9999'),(104,'Wilson','2000-11-17',72.80,177.00,23.20,'321 Elm St',4,5,2,'999-888-7777'),(105,'Anderson','1994-07-12',54.50,163.00,20.50,'555 Pine St',2,4,1,'888-999-6666'),(106,'Anon','2002-04-07',54.76,154.26,24.76,'345,colony',1,3,2,'9876567895'),(107,'Akash','2001-08-07',54.76,154.26,24.76,'345,colony',2,3,2,'9876567895'),(108,'Amal','2001-08-07',54.76,154.26,24.76,'345,colony',2,3,2,'9876567895'),(109,'Amala','2000-03-19',54.76,154.26,24.76,'345,colony',2,3,2,'9876567895'),(110,'Anu','1997-03-19',54.76,154.26,24.76,'345,colony',2,3,2,'9873457895'),(111,'Amala','2000-03-19',54.76,154.26,24.76,'345,colony',2,3,2,'9876567895');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_trainer_relationship`
--

DROP TABLE IF EXISTS `customer_trainer_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_trainer_relationship` (
  `relationship_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `trainer_id` int DEFAULT NULL,
  PRIMARY KEY (`relationship_id`),
  UNIQUE KEY `customer_id` (`customer_id`,`trainer_id`),
  KEY `trainer_id` (`trainer_id`),
  CONSTRAINT `customer_trainer_relationship_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `customer_trainer_relationship_ibfk_2` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_trainer_relationship`
--

LOCK TABLES `customer_trainer_relationship` WRITE;
/*!40000 ALTER TABLE `customer_trainer_relationship` DISABLE KEYS */;
INSERT INTO `customer_trainer_relationship` VALUES (5,101,302),(6,102,304),(8,104,304),(7,105,301),(9,105,306),(10,106,304),(20,110,323),(19,111,323);
/*!40000 ALTER TABLE `customer_trainer_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `description`
--

DROP TABLE IF EXISTS `description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `description` (
  `description_id` int NOT NULL AUTO_INCREMENT,
  `description_name` text,
  PRIMARY KEY (`description_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `description`
--

LOCK TABLES `description` WRITE;
/*!40000 ALTER TABLE `description` DISABLE KEYS */;
INSERT INTO `description` VALUES (1,'Certified Personal Trainer with 10+ years of experience specializing in weightlifting and strength training'),(2,'Former professional athlete with a passion for helping clients achieve their fitness goals'),(3,'Certified Yoga and Pilates instructor with a focus on mindfulness and flexibility'),(4,'Nutrition expert dedicated to promoting healthy eating habits and sustainable lifestyle changes'),(5,'Experienced marathon coach who has trained athletes to achieve personal bests and complete races'),(6,'Lose 10 pounds by the end of the year.'),(7,'Run a half-marathon within the next six months.'),(8,'Increase bench press max by 20% in the next three months.'),(9,'Achieve a body fat percentage of 15% by the target date.'),(10,'Complete a 30-day yoga challenge and improve flexibility.'),(11,'Bodybuilding champion and fitness coach known for transforming clients\' lives and promoting healthy living in the community  '),(12,'Bodybuilding champion and fitness coach known for transforming clients\' lives and promoting healthy living in the community  '),(13,'Bodybuilding champion and fitness coach known for transforming clients\' lives and promoting healthy living in the community  '),(14,'Bodybuilding champion and fitness coach known for transforming clients\' lives and promoting healthy living in the community  ');
/*!40000 ALTER TABLE `description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dietary_habits`
--

DROP TABLE IF EXISTS `dietary_habits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dietary_habits` (
  `dietary_habits_id` int NOT NULL AUTO_INCREMENT,
  `food_name` varchar(100) NOT NULL,
  `activity_id` int NOT NULL,
  `food_date_time` timestamp NOT NULL,
  `food_quantity` decimal(10,2) NOT NULL,
  `food_calories` decimal(10,2) NOT NULL,
  `description_id` int NOT NULL,
  PRIMARY KEY (`dietary_habits_id`),
  KEY `activity_id` (`activity_id`),
  KEY `description_id` (`description_id`),
  CONSTRAINT `dietary_habits_ibfk_1` FOREIGN KEY (`activity_id`) REFERENCES `fitness_activities` (`activity_id`),
  CONSTRAINT `dietary_habits_ibfk_2` FOREIGN KEY (`description_id`) REFERENCES `description` (`description_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dietary_habits`
--

LOCK TABLES `dietary_habits` WRITE;
/*!40000 ALTER TABLE `dietary_habits` DISABLE KEYS */;
INSERT INTO `dietary_habits` VALUES (1,'Chicken Salad',1,'2023-10-05 07:00:00',300.50,250.25,1),(2,'Oatmeal',2,'2023-10-05 02:30:00',200.75,150.75,2),(3,'Grilled Salmon',3,'2023-10-06 13:45:00',400.25,350.00,3),(4,'Spinach Smoothie',4,'2023-10-06 02:15:00',250.00,180.50,4),(5,'Steak and Potatoes',5,'2023-10-07 14:30:00',500.75,450.25,5);
/*!40000 ALTER TABLE `dietary_habits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fitness_activities`
--

DROP TABLE IF EXISTS `fitness_activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fitness_activities` (
  `activity_id` int NOT NULL AUTO_INCREMENT,
  `activity_type_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `activity_date` date NOT NULL,
  `activity_duration` time DEFAULT NULL,
  `calories_burn` decimal(10,2) NOT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `activity_type_id` (`activity_type_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `fitness_activities_ibfk_1` FOREIGN KEY (`activity_type_id`) REFERENCES `activity_type` (`activity_type_id`),
  CONSTRAINT `fitness_activities_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fitness_activities`
--

LOCK TABLES `fitness_activities` WRITE;
/*!40000 ALTER TABLE `fitness_activities` DISABLE KEYS */;
INSERT INTO `fitness_activities` VALUES (1,2,101,'2023-08-25','00:30:00',100.25),(2,3,101,'2023-08-25','01:00:00',250.50),(3,1,104,'2023-04-18','01:45:00',300.75),(4,5,105,'2023-04-18','01:00:00',250.50),(5,4,102,'2023-05-22','01:45:00',300.75),(6,3,105,'2023-04-18','01:00:00',400.00);
/*!40000 ALTER TABLE `fitness_activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goals`
--

DROP TABLE IF EXISTS `goals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goals` (
  `goal_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `description_id` int NOT NULL,
  `target_date` date NOT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`goal_id`),
  KEY `customer_id` (`customer_id`),
  KEY `description_id` (`description_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `goals_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `goals_ibfk_2` FOREIGN KEY (`description_id`) REFERENCES `description` (`description_id`),
  CONSTRAINT `goals_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goals`
--

LOCK TABLES `goals` WRITE;
/*!40000 ALTER TABLE `goals` DISABLE KEYS */;
INSERT INTO `goals` VALUES (1,101,6,'2023-12-31',1),(2,102,8,'2023-11-30',2),(3,103,7,'2024-01-15',1),(4,104,10,'2023-10-31',4),(5,105,9,'2023-12-25',4);
/*!40000 ALTER TABLE `goals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `state_id` int NOT NULL,
  `state_name` varchar(25) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'New York'),(2,'California'),(3,'Ontario'),(4,'TamilNadu'),(5,'Manchester'),(40,'TamilNadu');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status_name` varchar(20) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Active'),(2,'Completed'),(3,'On Hold'),(4,'Cancelled');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer` (
  `trainer_id` int NOT NULL,
  `trainer_name` varchar(50) NOT NULL,
  `trainer_experience` int NOT NULL,
  `description_id` int NOT NULL,
  `city_id` int NOT NULL,
  `state_id` int NOT NULL,
  `country_id` int NOT NULL,
  `trainer_number` varchar(20) NOT NULL,
  PRIMARY KEY (`trainer_id`),
  KEY `description_id` (`description_id`),
  KEY `city_id` (`city_id`),
  KEY `state_id` (`state_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `trainer_ibfk_1` FOREIGN KEY (`description_id`) REFERENCES `description` (`description_id`),
  CONSTRAINT `trainer_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`),
  CONSTRAINT `trainer_ibfk_3` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`),
  CONSTRAINT `trainer_ibfk_4` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (234,'Suman',0,2,1,1,2,'89058904'),(301,'John',10,1,1,1,1,'555-123-4567'),(302,'Davis',6,2,3,2,1,'444-777-8888'),(303,'Johnson',10,3,5,1,3,'123-234-5678'),(304,'Martin',8,4,1,3,2,'777-555-9999'),(305,'Lional',12,5,4,5,2,'999-888-7777'),(306,'Brawin',5,3,4,2,1,'7895634567'),(307,'vimal',4,3,2,3,2,'56789032'),(308,'kamal',4,2,3,2,3,'098765432'),(309,'Gokul',6,3,2,4,1,'9876567894'),(310,'Harish',3,3,2,4,1,'8768945678'),(311,'Ram',3,2,3,4,1,'6789054367'),(312,'anon',3,2,3,2,3,'98765432'),(313,'Graham',8,4,3,4,2,'9876543345'),(314,'fafal',4,3,2,3,2,'9876545678'),(315,'Karthick',4,1,1,2,2,'7895678945'),(316,'kajal',5,13,6,4,6,'7890634566'),(317,'kajal',5,14,30,40,6,'7890634566'),(318,'Guna',10,6,4,1,3,'745-3456-34567'),(319,'Karunya',5,4,3,2,2,'7895678456'),(320,'simra',5,4,3,2,2,'78956745656'),(321,'Gunal',10,6,4,1,3,'745-3456-34567'),(323,'simbu',5,4,3,2,2,'78956745656'),(325,'suresh',3,2,3,2,1,'6578935623'),(327,'Suman',7,2,1,1,2,'8905678904'),(328,'gokulakannan',0,3,4,3,2,'7896785670'),(329,'sivan',8,3,4,3,2,'9876567890'),(330,'shami',10,2,3,2,1,'6789045678'),(331,'sundar',7,1,1,2,2,'6789045678'),(332,'Kadal',3,1,4,3,2,'6789045678'),(333,'Gouthami',5,2,1,1,2,'6789045678'),(334,'karishma',4,2,3,2,2,'7890567489'),(335,'kushi',6,1,30,40,6,'6789056789'),(336,'nikil',1,4,3,2,1,'6784567895'),(337,'Sarath',10,2,3,2,1,'6789045678'),(340,'sindhu',6,7,4,1,1,'9876545678'),(341,'kureshi',5,6,4,2,1,'6574567890'),(342,'Karthika',5,4,3,2,2,'7895678456'),(343,'kagar',9,4,3,3,2,'6789045678'),(344,'gandhi',9,2,5,3,3,'6789045678'),(345,'Gowshik',5,2,3,2,3,'6789045678'),(346,'Malathi',5,4,3,2,2,'78956733226'),(347,'Sugumar',7,7,3,3,3,'76789045678'),(348,'Mariya',10,4,6,4,6,'7890656789'),(367,'Nakul',7,8,2,2,1,'8789045678');
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-31 15:54:17
