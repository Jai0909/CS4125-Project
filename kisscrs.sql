CREATE DATABASE IF NOT EXISTS KISSCARS;
CREATE TABLE IF NOT EXISTS `User` (
	`name` VARCHAR(255) NOT NULL,
	`phoneno` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`address` VARCHAR(255) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`dateOfBirth` DATE NOT NULL,
	`userMilage` INT DEFAULT NULL,
	PRIMARY KEY (`email`)
);
CREATE TABLE IF NOT EXISTS `Car` (
	`reg_no` VARCHAR(255) NOT NULL,
	`type` CHAR(20)  NOT NULL,
	`makeAndModel` VARCHAR(255) NOT NULL,
	`milage` INT NOT NULL,
	`price` INT NOT NULL,
	`damages` TINYINT(1) NOT NULL,
	`availability` TINYINT(1) NOT NULL,
	PRIMARY KEY (`reg_no`)
);
CREATE TABLE IF NOT EXISTS `Booking` (
	`reg_no` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`booking_id` INT NOT NULL AUTO_INCREMENT,
	`start_date` DATE NOT NULL,
	`end_date` DATE NOT NULL,
	PRIMARY KEY (`booking_id`),
	FOREIGN KEY (`reg_no`) REFERENCES Car(`reg_no`),
	FOREIGN KEY (`email`) REFERENCES User(`email`)
);
CREATE TABLE IF NOT EXISTS `Payment` (
	`payment_id` INT NOT NULL AUTO_INCREMENT,
	`card_no` INT NOT NULL,
	`exp_month` INT NOT NULL,
	`exp_year` INT NOT NULL,
	`cvv` INT NOT NULL,
	`card_holder` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`payment_id`),
	FOREIGN KEY (`email`) REFERENCES User(`email`)
);