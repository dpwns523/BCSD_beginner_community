package repository;

import domain.dto.BoardCommentDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCommentMapper {
    /*
        게시글 댓글 CRUD
     */
    void createComment(@Param(value = "commentDto")BoardCommentDto boardCommentDto);
    void updateComment(@Param(value = "commentDto")BoardCommentDto boardCommentDto);
    BoardCommentDto getCommentToId(@Param(value ="id")Long commentId);
    void deleteComment(@Param(value="id")Long commentId);
}
