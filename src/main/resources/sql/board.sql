CREATE DATABASE IF NOT EXISTS COMMUNITY;
DROP TABLE IF EXISTS `COMMUNITY`.`BOARDS`;
CREATE TABLE `COMMUNITY`.`BOARDS`(
                                     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                     `member_id` BIGINT(20) NOT NULL,
                                     `title` VARCHAR(20) NOT NULL,
                                     `nick_name` TEXT NOT NULL,
                                     `contents` VARCHAR(1000) NOT NULL,
                                     `updated_at` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
                                     `created_at` TIMESTAMP NOT NULL DEFAULT NOW(),
                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- test 데이터 생성
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트1", "창조1", "1. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트2", "창조1", "2. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트3", "창조1", "3. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트4", "창조1", "4. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트5", "창조1", "5. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트6", "창조1", "6. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트7", "창조1", "7. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (1, "테스트8", "창조1", "8. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트9", "창조2", "9. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트10", "창조2", "10. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트11", "창조2", "11. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트12", "창조2", "12. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트13", "창조2", "13. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트14", "창조2", "14. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트15", "창조2", "15. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (2, "테스트16", "창조2", "16. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (3, "테스트17", "창조3", "17. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (3, "테스트18", "창조3", "18. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (3, "테스트19", "창조3", "19. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (3, "테스트20", "창조3", "20. 테스트 게시글입니다.");
INSERT INTO `boards`(`member_id`, `title`, `nick_name`, `contents`)
VALUES (3, "테스트21", "창조3", "21. 테스트 게시글입니다.");

