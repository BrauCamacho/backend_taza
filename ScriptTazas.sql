SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tazas3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tazas3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tazas3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tazas3` ;

-- -----------------------------------------------------
-- Table `tazas3`.`taza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tazas3`.`taza` (
  `id_taza` INT NOT NULL AUTO_INCREMENT,
  `calidad` VARCHAR(255) NULL DEFAULT NULL,
  `capacidad` VARCHAR(255) NULL DEFAULT NULL,
  `color` VARCHAR(255) NULL DEFAULT NULL,
  `material` VARCHAR(255) NULL DEFAULT NULL,
  `modelo` VARCHAR(255) NULL DEFAULT NULL,
  `stock` INT NOT NULL,
  PRIMARY KEY (`id_taza`))
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tazas3`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tazas3`.`venta` (
  `id_venta` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `id_taza` INT NOT NULL,
  PRIMARY KEY (`id_venta`))
ENGINE = MyISAM
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `tazas3`;

DELIMITER $$
USE `tazas3`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `tazas3`.`trigger_compra`
AFTER INSERT ON `tazas3`.`venta`
FOR EACH ROW
BEGIN
         update taza set stock = stock- new.cantidad where new.id_taza = taza.id_taza;
         
       END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
