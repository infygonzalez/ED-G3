-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: viajeserrekamari
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `aerolinea`
--

DROP TABLE IF EXISTS `aerolinea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aerolinea` (
  `CodigoAerolinea` char(3) COLLATE utf16_spanish_ci NOT NULL,
  `NombreAerolinea` varchar(80) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`CodigoAerolinea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aerolinea`
--

LOCK TABLES `aerolinea` WRITE;
/*!40000 ALTER TABLE `aerolinea` DISABLE KEYS */;
INSERT INTO `aerolinea` VALUES ('2K','AVIANCA-Ecuador dba AVIANCA'),('3P','World 2 Fly Portugal, S.A.'),('6B*','TUIfly Nordic AB'),('A0','BA Euroflyer Limited dba British Airways'),('AA','American Airlines'),('AC','Air France'),('AM','Aerovias de Mexico SA de CV dba AeroMexico'),('AR','Aerolineas Argentinas S.A.'),('AV','Aerovias del Continente Americano S.A. AVIANCA'),('AY','Finnair'),('AZ','Alitalia'),('BA','British Airways PLC'),('CL','Lufthansa CityLine GmbH'),('DE','Condor Flugdienst GmbH'),('DL','Delta Air Lines Inc'),('DS','Easyjet Switzerland S.A'),('GL','Air Greenland'),('JJ','Tam Linhas Aereas SA dba Latam Airlines Brasil'),('KL','KLM'),('KN','China United Airlines'),('LH','Lufthansa'),('LX','SWISS International Air Lines Ltd'),('M3','BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br'),('MS','Egyptair'),('MT','Malta Air Travel Ltd dba Malta MedAir'),('N0','Norse Atlantic Airways AS'),('OU','Croatia Airlines d.d.'),('PC','Pegasus Airlines'),('QR','Qatar Airways Group Q.C.S.C dba Qatar Airways'),('RJ','Alia - The Royal Jordanian Airlines dba Royal Jordanian'),('RK','RYNAIR'),('S4','SATA Internacional - Azores Airlines, S.A.'),('SN','Brussels Airlines'),('SP','SATA (Air Acores)'),('TK','Turkish Airlines Inc'),('TP','TAP Portugal'),('TS','Air Transat'),('U2','EASYJET UK LIMITED'),('UA','United Airlines Inc'),('UX','Air Europa Lineas Aereas, S.A.'),('VOY','Aerolínea Vueling SA'),('VS','Virgin Atlantic Airways Ltd'),('WA','KLM Cityhopper'),('WFL','World2Fly'),('WK','Edelweiss Air AG'),('X3*','TUIfly Gmbh'),('X7','Challenge Airlines (BE) S.A.'),('YW','Air Nostrum, Lineas aereas del Mediterráneo SA');
/*!40000 ALTER TABLE `aerolinea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aeropuerto`
--

DROP TABLE IF EXISTS `aeropuerto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aeropuerto` (
  `CodigoAeropuerto` char(3) COLLATE utf16_spanish_ci NOT NULL,
  `NombreAeropuerto` varchar(60) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`CodigoAeropuerto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeropuerto`
--

LOCK TABLES `aeropuerto` WRITE;
/*!40000 ALTER TABLE `aeropuerto` DISABLE KEYS */;
INSERT INTO `aeropuerto` VALUES ('ACA','México (Acapulco)'),('ACE','Lanzarote'),('AGP','Málaga'),('ALC','Alicante'),('AMM','Jordania (Amán)'),('AMS','Holanda (Ámsterdam)'),('ATH','Grecia (Atenas)'),('BCN','Barcelona'),('BER','Alemania (Berlín)'),('BIO','Bilbao'),('BJZ','Badajoz'),('BKK','Tailandia (Bangkok)'),('BOG','Colombia (Bogotá)'),('BOS','Boston'),('BRU','Bélgica (Bruselas)'),('BSB','Brasil (Brasilia)'),('BUE','Buenos Aires'),('CAI','Egipto (El Cairo)'),('CAS','Marruecos (Casablanca)'),('CCS','Venezuela (Caracas)'),('CDG','Francia, París (Charles de Gaulle)'),('CPH','Dinamarca'),('DTT','Detroit'),('DUB','Irlanda (Dublín)'),('DUS','Alemania (Düsseldorf)'),('EAS','San Sebastián'),('FRA','Alemania (Frankfurt)'),('FUE','Fuerteventura'),('GMZ','La Gomera'),('GRO','Gerona'),('GRX','Granada'),('GVA','Suiza (Ginebra)'),('HAM','Alemania (Hamburgo)'),('HEL','Finlandia (Helsinki)'),('HOU','Houston'),('IBZ','Ibiza'),('IST','Turquía (Estambul)'),('JFK','Nueva York'),('KIN','Jamaica (Kingston)'),('LAX','Los Ángeles'),('LBG','Francia, Le Bourget'),('LCG','La Coruña'),('LGH','Londres (Gatwick)'),('LHR','Londres Heathrow'),('LIM','Perú (Lima)'),('LIS','Portugal (Lisboa)'),('LPA','Gran Canaria'),('LYS','Francia (Lyon)'),('MAD','Madrid'),('MAH','Mahon'),('MEL','Australia (Melbourne)'),('MEX','México D.F.'),('MIA','Miami'),('MIL','Italia (Milán)'),('MJV','Murcia'),('MOW','Rusia (Moscú)'),('MRS','Francia (Marsella)'),('MUC','Alemania (Múnich)'),('NBO','Kenia (Nairobi)'),('ODB','Córdoba'),('ORY','Francia (Orly)'),('OSL','Noruega (Oslo)'),('OVD','Asturias'),('PHL','Philadelphia'),('PMI','Palma de Mallorca'),('PNA','Pamplona'),('PRG','República Checa (Praga)'),('RAK','Marruecos (Marrakech)'),('REU','Reus'),('RIO','Brasil (Río de Janeiro)'),('SAO','Brasil (Sao Paulo)'),('SCQ','Santiago de Compostela'),('SDQ','República Dominicana (Santo Domingo)'),('SDR','Santander'),('SEA','Seattle'),('SFO','San Francisco'),('SLM','Salamanca'),('SPC','Santa Cruz de la Palma'),('STN','Londres (Stansted)'),('STO','Suecia (Estocolmo)'),('STR','Alemania (Stuttgart)'),('SYD','Australia (Sídney)'),('TFN','Tenerife Norte'),('TFS','Tenerife Sur'),('TUN','Túnez'),('VDE','Hierro'),('VGO','Vigo'),('VIE','Austria (Viena)'),('VIT','Vitoria'),('VLC','Valencia'),('WAS','Washington'),('WAW','Polonia (Varsovia)'),('XRY','Jerez de la Frontera'),('YMQ','Montreal, Québec'),('YOW','Ottawa, Ontario'),('YTO','Toronto, Ontario'),('YVR','Vancouver'),('ZAZ','Zaragoza'),('ZRH','Suiza (Zúrich)');
/*!40000 ALTER TABLE `aeropuerto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agencia`
--

DROP TABLE IF EXISTS `agencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agencia` (
  `NombreAgencia` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `Logo` varchar(512) COLLATE utf16_spanish_ci NOT NULL,
  `ColorMarca` varchar(7) COLLATE utf16_spanish_ci NOT NULL,
  `NumeroEmpleados` enum('Entre 2 y 10 empleados','Entre 10 y 100 empleados','Entre 100 y 1000 empleados') COLLATE utf16_spanish_ci NOT NULL,
  `TipoAgencia` enum('mayorista','minorista','mayorista-minorista') COLLATE utf16_spanish_ci NOT NULL,
  `Contraseña` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`NombreAgencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agencia`
--

LOCK TABLES `agencia` WRITE;
/*!40000 ALTER TABLE `agencia` DISABLE KEYS */;
INSERT INTO `agencia` VALUES ('Agencia Test','https://google.com','#ff5733','Entre 2 y 10 empleados','mayorista','3421'),('Dani Viajes','https://russafasingluten.com/img/cms/LOGOS/LOGODANI.png','#02fde6','Entre 10 y 100 empleados','mayorista-minorista','1'),('Viajes Erreka-Mari','https://i.imgur.com/OpMirsp.png','#000000','Entre 2 y 10 empleados','minorista','1234');
/*!40000 ALTER TABLE `agencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alojamiento`
--

DROP TABLE IF EXISTS `alojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alojamiento` (
  `EventoID` int NOT NULL AUTO_INCREMENT,
  `ViajeID` int NOT NULL,
  `NombreEvento` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `Precio` double NOT NULL,
  `NombreHotel` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `Ciudad` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `FechaEntrada` date NOT NULL,
  `FechaSalida` date NOT NULL,
  `TipoHabitacion` enum('DB','DUI','SIN','TPL') COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`EventoID`),
  KEY `fk_ViajeID_Alojamiento` (`ViajeID`),
  CONSTRAINT `fk_ViajeID_Alojamiento` FOREIGN KEY (`ViajeID`) REFERENCES `viaje` (`ViajeID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamiento`
--

LOCK TABLES `alojamiento` WRITE;
/*!40000 ALTER TABLE `alojamiento` DISABLE KEYS */;
INSERT INTO `alojamiento` VALUES (2,1,'1',10,'1','1','2025-02-04','2025-02-06','SIN'),(4,10,'1',1,'1','1','2025-02-01','2025-02-12','SIN');
/*!40000 ALTER TABLE `alojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otros`
--

DROP TABLE IF EXISTS `otros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otros` (
  `EventoID` int NOT NULL AUTO_INCREMENT,
  `ViajeID` int NOT NULL,
  `NombreEvento` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `Precio` double NOT NULL,
  `Fecha` date NOT NULL,
  `Descripcion` varchar(512) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`EventoID`),
  KEY `fk_ViajeID_Otros` (`ViajeID`),
  CONSTRAINT `fk_ViajeID_Otros` FOREIGN KEY (`ViajeID`) REFERENCES `viaje` (`ViajeID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otros`
--

LOCK TABLES `otros` WRITE;
/*!40000 ALTER TABLE `otros` DISABLE KEYS */;
INSERT INTO `otros` VALUES (4,10,'1',1,'2025-02-20','1');
/*!40000 ALTER TABLE `otros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `PaisCodigo` char(2) COLLATE utf16_spanish_ci NOT NULL,
  `DescripcionPais` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`PaisCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES ('AR','ARGENTINA'),('AT','AUSTRIA'),('BE','BÉLGICA'),('BR','BRASIL'),('CA','CANADÁ'),('CH','SUIZA'),('CN','CHINA'),('CU','CUBA'),('CY','CHIPRE'),('CZ','REPUBLICA CHECA'),('DE','ALEMANIA'),('DK','DINAMARCA'),('EE','ESTONIA'),('EG','EGIPTO'),('ES','ESPAÑA'),('FI','FINLANDIA'),('FR','FRANCIA'),('GB','REINO UNIDO'),('GR','GRECIA'),('GT','GUATEMALA'),('HK','HONG-KONG'),('HR','CROACIA'),('HU','HUNGRÍA'),('ID','INDONESIA'),('IE','IRLANDA'),('IL','ISRAEL'),('IN','INDIA'),('IS','ISLANDIA'),('IT','ITALIA'),('JM','JAMAICA'),('JP','JAPÓN'),('KE','KENIA'),('LU','LUXEMBURGO'),('MA','MARRUECOS'),('MC','MÓNACO'),('MT','MALTA'),('MV','MALDIVAS'),('MX','MÉXICO'),('NL','PAÍSES BAJOS'),('NO','NORUEGA'),('PA','PANAMÁ'),('PE','PERÚ'),('PL','POLONIA'),('PR','PUERTO RICO'),('PT','PORTUGAL'),('QA','QATAR'),('RO','RUMANIA'),('RU','RUSIA'),('SC','SEYCHELLES'),('SE','SUECIA'),('SG','SINGAPUR'),('TH','TAILANDIA'),('TN','TÚNEZ'),('TR','TURQUÍA'),('TZ','TANZANIA (INCLUYE ZANZIBAR)'),('US','ESTADOS UNIDOS'),('VE','VENEZUELA'),('VN','VIETNAM'),('ZA','SUDÁFRICA');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaje` (
  `ViajeID` int NOT NULL AUTO_INCREMENT,
  `NombreViaje` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `DescripcionViaje` varchar(512) COLLATE utf16_spanish_ci NOT NULL,
  `TipoViaje` enum('Novios','Senior','Grupos','Grandes viajes(destinos exoticos)','Combinado(vuelo+hotel)','Escapadas','Familias con niños menores') COLLATE utf16_spanish_ci NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `DuracionViaje` int GENERATED ALWAYS AS ((`FechaFin` - `FechaInicio`)) VIRTUAL,
  `ServiciosNoIncluidos` varchar(512) COLLATE utf16_spanish_ci NOT NULL,
  `NombreAgencia` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `PaisDestino` char(2) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`ViajeID`),
  KEY `fk_NombreAgencia_Viaje` (`NombreAgencia`),
  KEY `fk_PaisDestino_Viaje` (`PaisDestino`),
  CONSTRAINT `fk_NombreAgencia_Viaje` FOREIGN KEY (`NombreAgencia`) REFERENCES `agencia` (`NombreAgencia`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_PaisDestino_Viaje` FOREIGN KEY (`PaisDestino`) REFERENCES `pais` (`PaisCodigo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` (`ViajeID`, `NombreViaje`, `DescripcionViaje`, `TipoViaje`, `FechaInicio`, `FechaFin`, `ServiciosNoIncluidos`, `NombreAgencia`, `PaisDestino`) VALUES (1,'Viaje 1','aaaa','Novios','2024-01-01','2024-01-05','aaa','Viajes Erreka-Mari','RO'),(3,'11','aaaaaaaaaaab','Grupos','2025-02-05','2025-02-07','bbbbbbbbbba','Dani Viajes','AR'),(8,'99','9','Combinado(vuelo+hotel)','2025-02-06','2025-02-16','9','Viajes Erreka-Mari','AT'),(9,'00','0','Combinado(vuelo+hotel)','2025-02-01','2025-02-13','0','Viajes Erreka-Mari','CA'),(10,'aa','aaa','Grupos','2025-02-06','2025-02-22','aa','Viajes Erreka-Mari','AT'),(11,'aaa1','ccc','Senior','2025-02-12','2025-02-27','1s2','Viajes Erreka-Mari','AR'),(12,'a22','a','Senior','2025-02-10','2025-02-19','a','Viajes Erreka-Mari','AT');
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelo`
--

DROP TABLE IF EXISTS `vuelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelo` (
  `EventoID` int NOT NULL AUTO_INCREMENT,
  `ViajeID` int NOT NULL,
  `NombreEvento` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `Precio` double NOT NULL,
  `CodigoVuelo` varchar(10) COLLATE utf16_spanish_ci NOT NULL,
  `FechaSalida` date NOT NULL,
  `HoraSalida` time NOT NULL,
  `DuracionVuelo` time NOT NULL,
  `Aerolinea` char(3) COLLATE utf16_spanish_ci NOT NULL,
  `AeropuertoOrigen` char(3) COLLATE utf16_spanish_ci NOT NULL,
  `AeropuertoDestino` char(3) COLLATE utf16_spanish_ci NOT NULL,
  `EventoVueltaID` int DEFAULT NULL,
  PRIMARY KEY (`EventoID`),
  KEY `fk_ViajeID_Vuelo` (`ViajeID`),
  KEY `fk_Aerolinea_Vuelo` (`Aerolinea`),
  KEY `fk_AeropuertoOrigen_Vuelo` (`AeropuertoOrigen`),
  KEY `fk_AeropuertoDestino_Vuelo` (`AeropuertoDestino`),
  KEY `fk_EventoVueltaID_Vuelo` (`EventoVueltaID`),
  CONSTRAINT `fk_Aerolinea_Vuelo` FOREIGN KEY (`Aerolinea`) REFERENCES `aerolinea` (`CodigoAerolinea`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_AeropuertoDestino_Vuelo` FOREIGN KEY (`AeropuertoDestino`) REFERENCES `aeropuerto` (`CodigoAeropuerto`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_AeropuertoOrigen_Vuelo` FOREIGN KEY (`AeropuertoOrigen`) REFERENCES `aeropuerto` (`CodigoAeropuerto`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_EventoVueltaID_Vuelo` FOREIGN KEY (`EventoVueltaID`) REFERENCES `vuelo` (`EventoID`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_ViajeID_Vuelo` FOREIGN KEY (`ViajeID`) REFERENCES `viaje` (`ViajeID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelo`
--

LOCK TABLES `vuelo` WRITE;
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` VALUES (2,1,'Viaje Barcelona',550,'124','2025-02-03','02:00:00','01:30:00','MS','BCN','MAD',NULL),(3,1,'11',10,'34','2025-02-13','12:17:00','00:00:02','2K','AMM','AGP',NULL),(4,1,'11',10,'24','2025-02-04','12:17:00','00:00:01','2K','AGP','AMM',3),(6,9,'8nuevo',8,'8','2025-02-15','16:50:00','00:00:08','DE','BSB','BOS',NULL),(7,9,'8nuevo',8,'8','2025-02-15','16:50:00','00:00:08','DE','BSB','BOS',6),(8,9,'Vuelo prueba tiempo ',150,'23c','2025-02-14','14:24:00','-00:00:02','DS','ALC','AGP',NULL);
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-11  9:22:54
