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

import javax.servlet.http.HttpServletRequest;

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
    public BoardDto getBoard(Long boardId) throws MyException {
        BoardDto boardDto = boardMapper.getBoard(boardId);
        if(boardDto == null) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "존재하지 않는 게시물");
        return boardDto;
    }

    @Override
    public BaseResponse updateBoard(BoardDto boardDto, HttpServletRequest request) throws MyException {
        MemberDto memberDto = authService.authMember();
        if(memberDto.getNick_name() != boardDto.getNickName()) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "작성자만 수정할 수 있습니다.");
        boardMapper.updateBoard(boardDto);
        return new BaseResponse("수정 되었습니다.",HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoard(Long id) throws Exception {
        return null;
    }

}
