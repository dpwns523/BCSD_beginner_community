package service.impl;

import common.Constants;
import common.exception.MyException;
import domain.dto.BoardDto;
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
        boardMapper.createBoard(memberDto.getId(), memberDto.getNick_name(), board);
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
        System.out.println(memberDto.getNick_name() + boardDto.getNick_name());
        if(!memberDto.getNick_name().equals(boardDto.getNick_name())) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "작성자만 수정할 수 있습니다.");
        boardMapper.updateBoard(boardId, title, contents);
        return new BaseResponse("게시글이 수정 되었습니다.",HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoard(Long boardId) throws MyException {
        MemberDto memberDto = authService.authMember();
        BoardDto boardDto = boardMapper.getBoardToId(boardId);
        if(!memberDto.getNick_name().equals(boardDto.getNick_name())) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "작성자만 삭제할 수 있습니다.");
        boardMapper.deleteBoard(boardId);
        return new BaseResponse("게시글이 삭제 되었습니다.", HttpStatus.OK);
    }

}
