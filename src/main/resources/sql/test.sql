CREATE DATABASE IF NOT EXISTS COMMUNITY;
DROP TABLE IF EXISTS `COMMUNITY`.`TEST`;
CREATE TABLE `COMMUNITY`.`TEST`(
                                      `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                      `name` VARCHAR(20) NOT NULL,
                                      `password` TEXT NOT NULL,
                                      PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;
