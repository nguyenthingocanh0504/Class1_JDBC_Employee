-- MySQL Script generated by MySQL Workbench
-- Mon Mar 20 09:45:23 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema quanlynhansu
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema quanlysanpham
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema quanlysanpham
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `quanlysanpham` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `quanlysanpham` ;

-- -----------------------------------------------------
-- Table `quanlysanpham`.`ChucVu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quanlysanpham`.`ChucVu` (
  `MaCV` INT NOT NULL AUTO_INCREMENT,
  `TenCV` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`MaCV`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quanlysanpham`.`Luong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quanlysanpham`.`Luong` (
  `BacLuong` INT NOT NULL,
  `LuongCB` INT NOT NULL,
  `HSLuong` DOUBLE NOT NULL,
  `HSPhuCap` DOUBLE NOT NULL,
  PRIMARY KEY (`BacLuong`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quanlysanpham`.`PhongBan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quanlysanpham`.`PhongBan` (
  `MaPB` INT NOT NULL AUTO_INCREMENT,
  `TenPB` VARCHAR(45) NOT NULL,
  `SDTPB` VARCHAR(45) NOT NULL,
  `DiaChi` VARCHAR(45) NOT NULL,
  `TrangThai` TINYINT NOT NULL,
  PRIMARY KEY (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quanlysanpham`.`TrinhDoHocVan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quanlysanpham`.`TrinhDoHocVan` (
  `MaTrinhDoHocVan` INT NOT NULL AUTO_INCREMENT,
  `TTDHV` VARCHAR(45) NOT NULL,
  `ChuyenNganh` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MaTrinhDoHocVan`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `quanlysanpham`.`NhanVien`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quanlysanpham`.`NhanVien` (
  `MaNV` VARCHAR(20) NOT NULL,
  `HoTen` VARCHAR(45) NOT NULL,
  `SoDienThoai` VARCHAR(45) NOT NULL,
  `GioiTinh` VARCHAR(45) NOT NULL,
  `NgaySinh` VARCHAR(45) NOT NULL,
  `DanToc` VARCHAR(45) NOT NULL,
  `QueQuan` VARCHAR(45) NOT NULL,
  `MaPB` INT NOT NULL,
  `MaTrinhDoHocVan` INT NOT NULL,
  `BacLuong` INT NOT NULL,
  `MaCV` INT NOT NULL,
  `TrangThai` TINYINT NOT NULL,
  PRIMARY KEY (`MaNV`, `MaTrinhDoHocVan`, `BacLuong`, `MaCV`),
  INDEX `fk_nhanvien_phongban_idx` (`MaPB` ASC) VISIBLE,
  INDEX `fk_nhanvien_trinhdohocvan1_idx` (`MaTrinhDoHocVan` ASC) VISIBLE,
  INDEX `fk_nhanvien_luong1_idx` (`BacLuong` ASC) VISIBLE,
  INDEX `fk_nhanvien_chucvu1_idx` (`MaCV` ASC) VISIBLE,
  CONSTRAINT `fk_nhanvien_chucvu1`
    FOREIGN KEY (`MaCV`)
    REFERENCES `quanlysanpham`.`ChucVu` (`MaCV`),
  CONSTRAINT `fk_nhanvien_luong1`
    FOREIGN KEY (`BacLuong`)
    REFERENCES `quanlysanpham`.`Luong` (`BacLuong`),
  CONSTRAINT `fk_nhanvien_phongban`
    FOREIGN KEY (`MaPB`)
    REFERENCES `quanlysanpham`.`PhongBan` (`MaPB`),
  CONSTRAINT `fk_nhanvien_trinhdohocvan1`
    FOREIGN KEY (`MaTrinhDoHocVan`)
    REFERENCES `quanlysanpham`.`TrinhDoHocVan` (`MaTrinhDoHocVan`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

create table if not exists accounts(
	id varchar(20),
    username varchar(50),
    password varchar(50)
);

insert into accounts values ('001','LeBichThao','123456');
insert into accounts values ('002','NguyenNgocAnh','123456');
insert into accounts values ('003','LeThanhLy','123456');

 select * from accounts;