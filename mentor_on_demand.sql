-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mentor_on_demand
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mentor_on_demand
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mentor_on_demand` DEFAULT CHARACTER SET utf8 ;

USE `mentor_on_demand` ;

-- -----------------------------------------------------
-- Table `mentor_on_demand`.`mentor_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`mentor_details` (
  `md_id` INT NOT NULL AUTO_INCREMENT,
  `md_username` VARCHAR(45) NOT NULL,
  `md_firstname` VARCHAR(45) NOT NULL,
  `md_lastname` VARCHAR(45) NOT NULL,
  `md_email` VARCHAR(200) NOT NULL,
  `md_password` VARCHAR(200) NOT NULL,
  `md_contact` VARCHAR(10) NOT NULL,
  `md_linked_in_url` VARCHAR(200) NOT NULL,
  `md_facilities` VARCHAR(45) NOT NULL,
  `md_exp` FLOAT NOT NULL,
  `md_timings` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`md_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mentor_on_demand`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`user` (
  `us_name` VARCHAR(45) NOT NULL,
  `us_email` VARCHAR(200) NOT NULL,
  `us_password` VARCHAR(200) NOT NULL,
  `us_role` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `us_name_UNIQUE` (`us_name` ASC),
  UNIQUE INDEX `us_email_UNIQUE` (`us_email` ASC),
  PRIMARY KEY (`us_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mentor_on_demand`.`student_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mentor_on_demand`.`student_details` (
  `sd_id` INT NOT NULL,
  `sd_username` VARCHAR(45) NOT NULL,
  `sd_firstname` VARCHAR(45) NOT NULL,
  `sd_lastname` VARCHAR(45) NOT NULL,
  `sd_email` VARCHAR(200) NOT NULL,
  `sd_password` VARCHAR(200) NOT NULL,
  `sd_contact` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`sd_id`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
