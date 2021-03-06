package service;

import common.exception.MyException;
import domain.dto.BoardCommentDto;
import response.BaseResponse;

public interface BoardCommentService {
    /*
        게시글 댓글 CRUD
     */
    BaseResponse createComment(BoardCommentDto boardCommentDto) throws MyException;
    BaseResponse updateComment(Long id, BoardCommentDto boardCommentDto) throws MyException;
    BaseResponse deleteComment(Long boardCommentId) throws Exception;


}
