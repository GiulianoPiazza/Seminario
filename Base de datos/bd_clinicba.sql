CREATE DATABASE  IF NOT EXISTS `bd_clinicacba` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_clinicacba`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_clinicacba
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `DNI` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `medico_DNI` int NOT NULL,
  `turno_ID` int NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `medico_DNI` (`medico_DNI`),
  KEY `turno_ID` (`turno_ID`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`medico_DNI`) REFERENCES `medico` (`DNI`),
  CONSTRAINT `administrador_ibfk_2` FOREIGN KEY (`turno_ID`) REFERENCES `turno` (`ID_TURNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `ID_ESPECIALIDAD` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_ESPECIALIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `DNI` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `especialidad_ID` int NOT NULL,
  `paciente_DNI` int NOT NULL,
  `matricula` varchar(50) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `especialidad_ID` (`especialidad_ID`),
  KEY `paciente_DNI` (`paciente_DNI`),
  CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`especialidad_ID`) REFERENCES `especialidad` (`ID_ESPECIALIDAD`),
  CONSTRAINT `medico_ibfk_2` FOREIGN KEY (`paciente_DNI`) REFERENCES `paciente` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `DNI` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prioridad`
--

DROP TABLE IF EXISTS `prioridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prioridad` (
  `ID_PRIORIDAD` int NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_PRIORIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registro_atencion`
--

DROP TABLE IF EXISTS `registro_atencion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_atencion` (
  `ID_REGISTRO_ATENCION` int NOT NULL,
  `turno_ID` int NOT NULL,
  `medico_DNI` int NOT NULL,
  `paciente_DNI` int NOT NULL,
  `fecha_atencion` datetime DEFAULT NULL,
  `diagnostico` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_REGISTRO_ATENCION`),
  KEY `turno_ID` (`turno_ID`),
  KEY `medico_DNI` (`medico_DNI`),
  KEY `paciente_DNI` (`paciente_DNI`),
  CONSTRAINT `registro_atencion_ibfk_1` FOREIGN KEY (`turno_ID`) REFERENCES `turno` (`ID_TURNO`),
  CONSTRAINT `registro_atencion_ibfk_2` FOREIGN KEY (`medico_DNI`) REFERENCES `medico` (`DNI`),
  CONSTRAINT `registro_atencion_ibfk_3` FOREIGN KEY (`paciente_DNI`) REFERENCES `paciente` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reporte`
--

DROP TABLE IF EXISTS `reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reporte` (
  `ID_REPORTE` int NOT NULL,
  `fecha_generacion` datetime DEFAULT NULL,
  `medico_DNI` int NOT NULL,
  `pacientes_atendidos` int DEFAULT NULL,
  PRIMARY KEY (`ID_REPORTE`),
  KEY `medico_DNI` (`medico_DNI`),
  CONSTRAINT `reporte_ibfk_1` FOREIGN KEY (`medico_DNI`) REFERENCES `medico` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `ID_TURNO` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `prioridad_ID` int NOT NULL,
  `estado` enum('pendiente','atendido','cancelado') NOT NULL,
  `paciente_DNI` int NOT NULL,
  `medico_DNI` int NOT NULL,
  PRIMARY KEY (`ID_TURNO`),
  KEY `prioridad_ID` (`prioridad_ID`),
  KEY `paciente_DNI` (`paciente_DNI`),
  KEY `medico_DNI` (`medico_DNI`),
  CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`prioridad_ID`) REFERENCES `prioridad` (`ID_PRIORIDAD`),
  CONSTRAINT `turno_ibfk_2` FOREIGN KEY (`paciente_DNI`) REFERENCES `paciente` (`DNI`),
  CONSTRAINT `turno_ibfk_3` FOREIGN KEY (`medico_DNI`) REFERENCES `medico` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 23:01:02
