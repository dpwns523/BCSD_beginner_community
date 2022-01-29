package controller;

import annotation.ValidationGroups;
import domain.dto.BoardCommentDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BoardCommentService;

@Controller
@RequestMapping("/comment")
public class BoardCommentController {

    @Autowired
    private BoardCommentService boardCommentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "댓글 작성", notes = "댓글 작성 API")
    public ResponseEntity createComment(@RequestBody @Validated(ValidationGroups.comment.class) BoardCommentDto boardCommentDto) throws Exception{
        return new ResponseEntity(boardCommentService.createComment(boardCommentDto), HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ApiOperation(value = "댓글 수정", notes = "댓글 수정 API")
    public ResponseEntity updateComment(Long commentId, BoardCommentDto boardCommentDto) throws Exception{
        return new ResponseEntity(boardCommentService.updateComment(commentId, boardCommentDto), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation(value = "댓글 삭제", notes = "댓글 삭제 API")
    public ResponseEntity deleteComment(@RequestBody Long boardCommentId) throws Exception{
        return new ResponseEntity(boardCommentService.deleteComment(boardCommentId),HttpStatus.OK);
    }

    /*
        자기가 쓴 댓글들 보기 및 쓴 댓글의 게시판 제목 보기
     */



}
