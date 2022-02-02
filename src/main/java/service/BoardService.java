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

    // 게시글 내 댓글 불러오기
    BaseResponse getComments(Long boardId) throws Exception;
    // 게시글 목록 페이징
    BaseResponse getBoardList(int page) throws Exception;
    /*
        게시글 검색 - 제목, 내용
     */
    BaseResponse searchBoardToTitle(int page, String title) throws Exception;
    BaseResponse searchBoardToContents(int page, String contents) throws Exception;

}
