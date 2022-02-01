package service;

import domain.dto.BoardDto;
import response.BaseResponse;

public interface BoardService {
    /*
        게시글 CRUD
     */
    BaseResponse createBoard(BoardDto board) throws Exception;
    BaseResponse getBoard(Long boardId) throws Exception;
    BaseResponse updateBoard(Long boardId, String title, String contents) throws Exception;
    BaseResponse deleteBoard(Long boardId) throws Exception;

    BaseResponse getComments(Long boardId) throws Exception;

    BaseResponse getBoardList(int page) throws Exception;

}
