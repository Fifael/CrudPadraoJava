-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema trap
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trap
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trap` DEFAULT CHARACTER SET utf8 ;
USE `trap` ;

-- -----------------------------------------------------
-- Table `trap`.`Cantor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trap`.`Cantor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomeCantor` VARCHAR(60) NULL,
  `idade` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trap`.`Produtora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trap`.`Produtora` (
  `idProdutora` INT NOT NULL AUTO_INCREMENT,
  `nomeProdutora` VARCHAR(60) NULL,
  `genero` VARCHAR(40) NULL,
  `cidade` VARCHAR(45) NULL,
  `cantor_id` INT NOT NULL,
  PRIMARY KEY (`idProdutora`),
  INDEX `fk_Produtora_Cantor_idx` (`cantor_id` ASC) ,
  CONSTRAINT `fk_Produtora_Cantor`
    FOREIGN KEY (`cantor_id`)
    REFERENCES `trap`.`Cantor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
