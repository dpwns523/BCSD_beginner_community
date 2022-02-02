package repository;

import domain.dto.BoardCommentDto;
import domain.dto.BoardDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    /*
        게시글 CRUD
     */
    void createBoard(@Param(value="member_id") Long id, @Param(value = "boardDto") BoardDto boardDto);
    BoardDto getBoardToId(@Param(value="id")Long boardId);
    void updateBoard(@Param(value = "id")Long boardId, @Param(value="title")String title,@Param(value="contents")String contents);
    void deleteBoard(@Param(value = "id")Long boardId);
    /*
        게시글 pagination
     */
    int getBoardCnt();
    List<BoardDto> getBoardList(@Param(value="start")int start, @Param(value="range")int range);
    /*
        댓글 불러오기
     */
    List<BoardCommentDto> getComments(@Param(value = "board_id")Long boardId);
    /*
        게시글 검색
        TODO: 작성자 닉네임을 통한 게시글 검색
     */
    int countBoardToTitle(@Param(value = "title")String title);
    int countBoardToContents(@Param(value = "contents")String contents);
    List<BoardDto> searchToTitle(@Param(value ="title")String title, @Param(value="start")int start, @Param(value="range")int range);
    List<BoardDto> searchToContents(@Param(value ="contents")String contents, @Param(value="start")int start, @Param(value="range")int range);



}
