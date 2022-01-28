CREATE DATABASE IF NOT EXISTS COMMUNITY;
DROP TABLE IF EXISTS `COMMUNITY`.`BOARDS`;
CREATE TABLE `COMMUNITY`.`BOARDS`(
                                     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                     `member_id` BIGINT(20) NOT NULL,
                                     `title` VARCHAR(20) NOT NULL,
                                     `contents` VARCHAR(1000) NOT NULL,
                                     `updated_at` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
                                     `created_at` TIMESTAMP NOT NULL DEFAULT NOW(),
                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

