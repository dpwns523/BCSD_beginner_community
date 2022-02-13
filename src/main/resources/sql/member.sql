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
                                    `updated_at` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
                                    `created_at` TIMESTAMP NOT NULL DEFAULT NOW(),
                                    PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- Test용 데이터
INSERT INTO `members`(`name`, `password`, `email`, `nick_name`, `phone_number`, age, sex)
VALUES ("임예준", "password", "dpwns523@naver.com", "창조1",
        "01066040868",25, 1);
INSERT INTO `members`(`name`, `password`, `email`, `nick_name`, `phone_number`, age, sex)
VALUES ("임예준", "password", "dpwns523@daum.net", "창조2",
        "01066040868",25, 1);
INSERT INTO `members`(`name`, `password`, `email`, `nick_name`, `phone_number`, age, sex)
VALUES ("임예준", "password", "dpwns523@koreatech.ac.kr", "창조3",
        "01066040868",25, 1);

-- 테이블 수정 사항
ALTER TABLE `members` ADD UNIQUE(nick_name), ADD UNIQUE(email);

