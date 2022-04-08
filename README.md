# WeatherApp-Backend

Sql query

CREATE TABLE `weather_location` (
  `location_id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(45) NOT NULL,
  `location_order` int DEFAULT '0',
  PRIMARY KEY (`location_id`),
  UNIQUE KEY `location_UNIQUE` (`location`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Eureka server :
username: eurekaserver
password:eurekaserver
