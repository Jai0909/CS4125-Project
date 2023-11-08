# -- Create the database if it doesn't exist
# CREATE DATABASE IF NOT EXISTS vehicleRental;
#
# -- Use the vehicleRental database
# USE vehicleRental;
#
# -- Create the User table
# CREATE TABLE `User` (
#     `name` VARCHAR(255) DEFAULT NULL,
#     `phoneno` VARCHAR(255) DEFAULT '',
#     `email` VARCHAR(255) NOT NULL,
#     `address` VARCHAR(255) DEFAULT NULL,
#     `password` VARCHAR(255) DEFAULT NULL,
#     `dateOfBirth` DATE DEFAULT NULL,
#     `userMilage` INT DEFAULT NULL,
#     PRIMARY KEY (`email`)
# );
#
# -- Create the Booking table
# CREATE TABLE `Booking` (
#     `reg_no` VARCHAR(255) DEFAULT NULL,
#     `email` VARCHAR(255) DEFAULT NULL,
#     `booking_id` INT NOT NULL AUTO_INCREMENT,
#     `start_date` DATE DEFAULT NULL,
#     `end_date` DATE DEFAULT NULL,
#     PRIMARY KEY (`booking_id`)
# );
#
# -- Create the Car table
# CREATE TABLE `Car` (
#     `reg_no` VARCHAR(255) NOT NULL,
#     `type` CHAR(20) DEFAULT NULL,
#     `makeAndModel` VARCHAR(255) DEFAULT NULL,
#     `milage` INT DEFAULT NULL,
#     `price` INT DEFAULT NULL,
#     `damages` TINYINT(1) DEFAULT NULL,
#     `availability` TINYINT(1) DEFAULT NULL,
#     PRIMARY KEY (`reg_no`)
# );
#
# -- Create the Payment table
# CREATE TABLE `Payment` (
#     `payment_id` INT NOT NULL,
#     `card_no` INT DEFAULT NULL,
#     `exp_month` INT DEFAULT NULL,
#     `exp_year` INT DEFAULT NULL,
#     `cvv` INT DEFAULT NULL,
#     `card_holder` VARCHAR(255) DEFAULT NULL,
#     `email` VARCHAR(255) DEFAULT NULL,
#     PRIMARY KEY (`payment_id`)
# );
#
# INSERT INTO `User` (`name`, `phoneno`, `email`, `address`, `password`, `date_of_birth`, `user_milage`, `id`) VALUES ('cael', '0891', 'cael@gmail', 'two west cael st', 'cael', '2003-02-02', '20', '1');
# INSERT INTO `User` (`name`, `phoneno`, `email`, `address`, `password`, `date_of_birth`, `user_milage`, `id`) VALUES ('rohan', '0892', 'rohan@gmail', 'two west rohan st', 'rohan', '2003-02-02', '20', '2');
# INSERT INTO `User` (`name`, `phoneno`, `email`, `address`, `password`, `date_of_birth`, `user_milage`, `id`) VALUES ('dennis', '0893', 'dennis@gmail', 'two west dennis st', 'dennis', '2003-02-02', '20', '3');
# INSERT INTO `User` (`name`, `phoneno`, `email`, `address`, `password`, `date_of_birth`, `user_milage`, `id`) VALUES ('jai', '0894', 'jai@gmail', 'two west jai st', 'jai', '2003-02-02', '20', '4');
#
