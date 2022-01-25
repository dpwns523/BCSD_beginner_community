package service;

import domain.dto.BoardDto;
import response.BaseResponse;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
    BaseResponse createBoard(BoardDto board, HttpServletRequest request) throws Exception;

//    List<BoardDto> getSummaryBoardList(BoardSearchModel board) throws Exception;

    BoardDto getBoard(Long boardId) throws Exception;

    BaseResponse updateBoard(BoardDto boardDto, HttpServletRequest request) throws Exception;

    BaseResponse deleteBoard(Long id) throws Exception;

}
