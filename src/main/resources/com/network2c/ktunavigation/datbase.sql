
--create database
CREATE schema ktu_navigation;


--table for student
CREATE TABLE `student` (
   `id` int NOT NULL AUTO_INCREMENT,
   `name` varchar(45) NOT NULL,
   `index` varchar(45) NOT NULL,
   PRIMARY KEY (`id`)
 )


--table for admin credentials
CREATE TABLE `ktu_navigation`.`admin_details` (
  `Name` VARCHAR(255) NOT NULL,
  `idNumber` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`password`));


--table for visitors
CREATE TABLE `visitors` (
   `id` int NOT NULL AUTO_INCREMENT,
   `name` varchar(45) NOT NULL,
   `phone` int NOT NULL,
   PRIMARY KEY (`id`)
 )

 --locations table
CREATE TABLE `locations` (
   `id` int NOT NULL AUTO_INCREMENT,
   `Name` varchar(45) NOT NULL,
   `Lat` decimal(10,8) NOT NULL,
   `Long` decimal(10,8) NOT NULL,
   PRIMARY KEY (`id`)
 )
