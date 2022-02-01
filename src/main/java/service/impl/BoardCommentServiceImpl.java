package service.impl;

import common.Constants;
import common.exception.MyException;
import domain.dto.BoardCommentDto;
import domain.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.BoardCommentMapper;
import response.BaseResponse;
import service.AuthService;
import service.BoardCommentService;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {

    @Autowired
    private BoardCommentMapper boardCommentMapper;

    @Autowired
    private AuthService authService;
    /*
        Comment는 게시글을 클릭해서 들어오는 Front에서 BoardId가 setting되었다 생각.
     */
    @Override
    public BaseResponse createComment(BoardCommentDto boardCommentDto) throws MyException {
        MemberDto memberDto = authService.authMember();
        boardCommentDto.setMemberId(memberDto.getId());
        boardCommentMapper.createComment(boardCommentDto);
        return new BaseResponse("댓글이 등록되었습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse updateComment(Long commentId, BoardCommentDto boardCommentDto) throws MyException {
        MemberDto memberDto = authService.authMember();
        boardCommentDto.setId(commentId);
        if(memberDto.getId() != boardCommentDto.getMemberId())
            throw new MyException(Constants.ExceptionClass.COMMENT,HttpStatus.BAD_REQUEST, "작성자만 수정할 수 있습니다.");
        boardCommentMapper.updateComment(boardCommentDto);
        return new BaseResponse("댓글이 수정되었습니다.", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteComment(Long boardCommentId) throws Exception {
        MemberDto memberDto = authService.authMember();
        BoardCommentDto boardCommentDto = boardCommentMapper.getCommentToId(boardCommentId);
        if(memberDto.getId() != boardCommentDto.getMemberId())
            throw new MyException(Constants.ExceptionClass.COMMENT,HttpStatus.BAD_REQUEST, "작성자만 삭제할 수 있습니다.");
        boardCommentMapper.deleteComment(boardCommentId);
        return new BaseResponse("댓글이 삭제되었습니다.", HttpStatus.OK);
    }

}
