-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: learnersacademy
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `admin_username` varchar(20) NOT NULL,
  `admin_password` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('agis','123');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `class_id` int NOT NULL,
  `class_name` varchar(10) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'CLASS A1'),(2,'CLASS A2'),(3,'CLASS A3');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL,
  `student_surname` varchar(30) NOT NULL,
  `student_name` varchar(30) NOT NULL,
  `student_middlename` varchar(30) DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1601,'Perkins','Thomas','Eric',1),(1602,'Miles','Simon','Paul',2),(1603,'Gavin','Frank','Walter',3),(1604,'Leigh','John','Lee',2),(1606,'McIntire','John','William',1),(1609,'Albertson','Samantha','Beatrice',2),(1610,'Allen','Derek','James',3),(1612,'Beers','Frank','Matthew',2),(1613,'Carson','Lee','George',1),(1616,'Jasmin','Virginia','Mary',2),(1619,'Knight','Fletcher','Philip',3),(1620,'Henshaw','Daphne','Sognia',3),(1623,'Riggs','Magdalene','Sophia',1),(1624,'Barron','Florence','Helen',2),(1629,'Berke','David','Julian',3),(1630,'Bone','Harold','James',2),(1631,'Gills','Ronald','Lee',1),(1636,'Mills','Lisa','Marie',3),(1637,'Mills','Lisa','Georgia',3);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subject_id` int NOT NULL,
  `subject_name` varchar(20) NOT NULL,
  `class_id` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'English',101,10),(2,'Math',11,6),(3,'Art',100,2),(4,'Science',1,13),(5,'History',110,7),(6,'Music',100,14),(7,'Geography',100,4),(8,'Drama',10,1),(9,'Biology',11,15),(10,'Chemistry',110,12),(11,'Physics',110,8),(12,'Foreign_Langs',101,3),(13,'Social_Studies',11,9),(14,'Technology',1,11),(15,'Philosophy',1,5);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `teacher_id` int NOT NULL,
  `teacher_surname` varchar(30) NOT NULL,
  `teacher_name` varchar(30) DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'Johnson','Mary',8,10),(2,'Goodman','Phil',3,100),(3,'Palmer','William',12,101),(4,'Phillips','Elisabeth',7,100),(5,'Johanson','Mark',15,1),(6,'DePalma','Rosie',2,11),(7,'Ricketts','Ian',5,110),(8,'Moore','Dennis',11,110),(9,'Redwood','Cynthia',13,11),(10,'Michaels','Cecily',1,101),(11,'Ventoza','Luis',14,1),(12,'Sherman','James',10,110),(13,'Perez','Jose',4,1),(14,'Mentoza','Mary',6,100),(15,'Black','William',9,11);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-11 22:17:09
