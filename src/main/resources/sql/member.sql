CREATE DATABASE IF NOT EXISTS COMMUNITY;
DROP TABLE IF EXISTS `COMMUNITY`.`MEMBERS`;
CREATE TABLE `COMMUNITY`.`MEMBERS`(
                                    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                    `name` VARCHAR(20) NOT NULL,
                                    `password` TEXT NOT NULL,
                                    `email` VARCHAR(50) NOT NULL,
                                    `nick_name` VARCHAR(50) NOT NULL,
                                    `phone_number` VARCHAR(50) NOT NULL,
                                    `age` BIGINT(10) NOT NULL,
                                    `sex` BIGINT(1) NOT NULL,
                                    `deleted` BOOLEAN NOT NULL DEFAULT FALSE,
                                    `updated_at` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
                                    `created_at` TIMESTAMP NOT NULL DEFAULT NOW(),
                                    PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;
