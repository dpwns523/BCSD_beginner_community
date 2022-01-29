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
    List<BoardCommentDto> getComments(@Param(value = "board_id")Long boardId);


}
