package service;

import domain.dto.BoardDto;
import response.BaseResponse;

public interface BoardService {
    BaseResponse createBoard(BoardDto board) throws Exception;

//    List<BoardDto> getSummaryBoardList(BoardSearchModel board) throws Exception;

    BaseResponse getBoard(Long boardId) throws Exception;

    BaseResponse updateBoard(Long boardId, String title, String contents) throws Exception;

    BaseResponse deleteBoard(Long boardId) throws Exception;

    BaseResponse getComments(Long boardId) throws Exception;

}
