CREATE DATABASE `foodplaza_boot`;

CREATE TABLE  `foodplaza_boot`.`user` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `foodplaza_boot`.`role` (
  `roleId` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(45) NOT NULL DEFAULT '',
  PRIMARY KEY(`role_id`)
)
ENGINE = InnoDB;

