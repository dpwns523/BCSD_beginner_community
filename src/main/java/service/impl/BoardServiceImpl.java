package service.impl;

import common.Constants;
import common.exception.MyException;
import domain.dto.BoardDto;
import domain.dto.BoardPaginationDto;
import domain.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.BoardMapper;
import response.BaseResponse;
import service.AuthService;
import service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private AuthService authService;

    @Override
    public BaseResponse createBoard(BoardDto board) throws Exception {
        // 로그인 검증
        MemberDto memberDto = authService.authMember();
        boardMapper.createBoard(memberDto.getId(), board);
        return new BaseResponse("게시글 등록", HttpStatus.OK);
    }

    // 게시글 열람
    @Override
    public BaseResponse getBoard(Long boardId) throws MyException {
        BoardDto boardDto = boardMapper.getBoardToId(boardId);
        if(boardDto == null) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "존재하지 않는 게시물입니다.");
        return new BaseResponse(boardDto.toString(),HttpStatus.OK);
    }

    @Override
    public BaseResponse updateBoard(Long boardId, String title, String contents) throws MyException {
        MemberDto memberDto = authService.authMember();
        BoardDto boardDto = boardMapper.getBoardToId(boardId);
        if(memberDto.getId() != boardDto.getMember_id()) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "작성자만 수정할 수 있습니다.");
        boardMapper.updateBoard(boardId, title, contents);
        return new BaseResponse("게시글이 수정 되었습니다.",HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoard(Long boardId) throws MyException {
        MemberDto memberDto = authService.authMember();
        BoardDto boardDto = boardMapper.getBoardToId(boardId);
        if(memberDto.getId() != boardDto.getMember_id()) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "작성자만 삭제할 수 있습니다.");
        boardMapper.deleteBoard(boardId);
        return new BaseResponse("게시글이 삭제 되었습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse getComments(Long boardId) throws Exception {
        BoardDto boardDto = boardMapper.getBoardToId(boardId);
        boardDto.setComments(boardMapper.getComments(boardId));
        return new BaseResponse(boardDto.getComments().toString(), HttpStatus.OK);
    }

    @Override
    public BaseResponse getBoardList(int page) throws Exception {
        BoardPaginationDto boardPaginationDto = new BoardPaginationDto();
        boardPaginationDto.setPageInfo(page, boardMapper.getBoardCnt());
        boardPaginationDto.setBoardList(boardMapper.getBoardList(boardPaginationDto.getStart(),boardPaginationDto.getRange()));
        return new BaseResponse(boardPaginationDto.getBoardList().toString(), HttpStatus.OK);
    }

    @Override
    public BaseResponse searchBoardToTitle(int page, String title) throws Exception {
        BoardPaginationDto boardPaginationDto = new BoardPaginationDto();
        boardPaginationDto.setPageInfo(page, boardMapper.countBoardToTitle(title));
        boardPaginationDto.setBoardList(boardMapper.searchToTitle(title, boardPaginationDto.getStart(),boardPaginationDto.getRange()));
        return new BaseResponse(boardPaginationDto.getBoardList().toString(), HttpStatus.OK);
    }

    @Override
    public BaseResponse searchBoardToContents(int page, String contents) throws Exception {
        BoardPaginationDto boardPaginationDto = new BoardPaginationDto();
        boardPaginationDto.setPageInfo(page, boardMapper.countBoardToTitle(contents));
        boardPaginationDto.setBoardList(boardMapper.searchToContents(contents, boardPaginationDto.getStart(),boardPaginationDto.getRange()));
        return new BaseResponse(boardPaginationDto.getBoardList().toString(), HttpStatus.OK);
    }
}
