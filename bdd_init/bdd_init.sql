-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema anciens_eleves
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema anciens_eleves
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `anciens_eleves` ;
USE `anciens_eleves` ;

-- -----------------------------------------------------
-- Table `anciens_eleves`.`alumni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`alumni` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `gender` TINYINT(1) NULL DEFAULT 1,
  `birthDate` DATE NULL,
  `note` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `anciens_eleves`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `mail` VARCHAR(100) NOT NULL DEFAULT 'non renseigné',
  `phone` VARCHAR(45) NOT NULL DEFAULT 'non renseigné',
  `entry_date` DATE NULL,
  `release_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `anciens_eleves`.`promotion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`promotion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `anciens_eleves`.`schooling`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`schooling` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `entry_date` DATE NOT NULL,
  `release_date` DATE NULL,
  `class_of_entry` VARCHAR(45) NOT NULL,
  `class_of_release` VARCHAR(45) NULL,
  `note` TEXT(1000) NULL,
  `alumni_id` INT NOT NULL,
  `promotion_id` INT NOT NULL,
  `jardinier_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_schooling_alumni1_idx` (`alumni_id` ASC) VISIBLE,
  INDEX `fk_schooling_promotion1_idx` (`promotion_id` ASC) VISIBLE,
  INDEX `fk_schooling_teacher1_idx` (`jardinier_id` ASC) VISIBLE,
  CONSTRAINT `fk_schooling_alumni1`
    FOREIGN KEY (`alumni_id`)
    REFERENCES `anciens_eleves`.`alumni` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_schooling_promotion1`
    FOREIGN KEY (`promotion_id`)
    REFERENCES `anciens_eleves`.`promotion` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_schooling_teacher1`
    FOREIGN KEY (`jardinier_id`)
    REFERENCES `anciens_eleves`.`teacher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `anciens_eleves`.`promotion_has_teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`promotion_has_teacher` (
  `promotion_id` INT NOT NULL,
  `teacher_id` INT NOT NULL,
  `role` ENUM('professeur de classe', 'tuteur grandes classes') NULL,
  `entry_date` DATE NULL,
  `release_date` DATE NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_promotion_has_teacher_teacher1_idx` (`teacher_id` ASC) VISIBLE,
  INDEX `fk_promotion_has_teacher_promotion_idx` (`promotion_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_promotion_has_teacher_promotion`
    FOREIGN KEY (`promotion_id`)
    REFERENCES `anciens_eleves`.`promotion` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_promotion_has_teacher_teacher1`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `anciens_eleves`.`teacher` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `anciens_eleves`.`study`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`study` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `diploma` VARCHAR(100) NULL,
  `school` VARCHAR(200) NOT NULL,
  `entry_date` DATE NULL,
  `release_date` DATE NULL,
  `note` TEXT(1000) NULL,
  `alumni_id` INT NOT NULL,
  `diploma_level` INT NULL,
  PRIMARY KEY (`id`, `alumni_id`),
  INDEX `fk_study_alumni1_idx` (`alumni_id` ASC) VISIBLE,
  CONSTRAINT `fk_study_alumni1`
    FOREIGN KEY (`alumni_id`)
    REFERENCES `anciens_eleves`.`alumni` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `anciens_eleves`.`job`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`job` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `entry_date` DATE NULL,
  `release_date` DATE NULL,
  `company` VARCHAR(200) NULL,
  `alumni_id` INT NOT NULL,
  PRIMARY KEY (`id`, `alumni_id`),
  INDEX `fk_job_alumni1_idx` (`alumni_id` ASC) VISIBLE,
  CONSTRAINT `fk_job_alumni1`
    FOREIGN KEY (`alumni_id`)
    REFERENCES `anciens_eleves`.`alumni` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `anciens_eleves`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `anciens_eleves`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(200) NOT NULL,
  `content` VARCHAR(200) NOT NULL,
  `alumni_id` INT NOT NULL,
  `usable` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`, `alumni_id`),
  INDEX `fk_contact_alumni1_idx` (`alumni_id` ASC) VISIBLE,
  CONSTRAINT `fk_contact_alumni1`
    FOREIGN KEY (`alumni_id`)
    REFERENCES `anciens_eleves`.`alumni` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
