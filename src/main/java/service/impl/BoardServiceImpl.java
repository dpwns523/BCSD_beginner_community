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
import javax.servlet.http.HttpSession;

@Service
public class BoardServiceImpl implements BoardService {
/*
    게시글을 작성한 Member의 정보가 무조건 있어야함.
 */
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private AuthService authService;

    @Override
    public BaseResponse createBoard(BoardDto board, HttpServletRequest request) throws Exception {
        // 로그인 검증
        HttpSession httpSession = request.getSession();
        Object object = httpSession.getAttribute("login");
        if(object == null) return new BaseResponse("로그인이 필요합니다.", HttpStatus.BAD_REQUEST);
        MemberDto memberDto = (MemberDto)object;
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
        HttpSession httpSession = request.getSession();
        Object object = httpSession.getAttribute("login");
        if(object == null) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "로그인이 필요합니다.");
        MemberDto memberDto = (MemberDto)object;
        if(memberDto.getNick_name() != boardDto.getNickName()) throw new MyException(Constants.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "작성자만 수정할 수 있습니다.");

        boardMapper.updateBoard(boardDto);
        return new BaseResponse("수정 되었습니다.",HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteBoard(Long id) throws Exception {
        return null;
    }

}
