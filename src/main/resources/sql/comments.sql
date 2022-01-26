CREATE DATABASE IF NOT EXISTS COMMUNITY;
DROP TABLE IF EXISTS `COMMUNITY`.`COMMENTS`;
CREATE TABLE `COMMUNITY`.`COMMENTS`(
                                     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                     `board_id` BIGINT(20) NOT NULL,
                                     `member_id` BIGINT(20) NOT NULL,
                                     `nick_name` TEXT NOT NULL,
                                     `contents` VARCHAR(1000) NOT NULL,
                                     `updated_at` TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
                                     `created_at` TIMESTAMP NOT NULL DEFAULT NOW(),
                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- test 데이터
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 1, "창조1", "1. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 1, "창조1", "2. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 1, "창조1", "3. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 1, "창조1", "4. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 1, "창조1", "5. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "6. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "7. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "8. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "9. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "10. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "11. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "12. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 2, "창조2", "13. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "14. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "15. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "16. 테스트 댓글입니다.");
INSERT INTO`comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "17. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "18. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "19. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "20. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "21. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "22. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "23. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "24. 테스트 댓글입니다.");
INSERT INTO `comments`(`board_id`, `member_id`, `nick_name`, `contents`)
VALUES (1, 3, "창조3", "25. 테스트 댓글입니다.");
