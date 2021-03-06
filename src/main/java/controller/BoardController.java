package controller;

import annotation.ValidationGroups;
import domain.dto.BoardDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value="",method = RequestMethod.POST)
    @ApiOperation(value = "게시글 작성", notes = "게시글 작성 API")
    public ResponseEntity createBoard(@RequestBody @Validated(ValidationGroups.board.class) BoardDto boardDto) throws Exception{
        return new ResponseEntity(boardService.createBoard(boardDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/{boardId}",method = RequestMethod.GET)
    @ApiOperation(value = "게시글 보기", notes = "게시글 보기 API")
    public ResponseEntity getBoard(Long boardId) throws Exception{
        return new ResponseEntity(boardService.getBoard(boardId),HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ApiOperation(value = "게시글 수정", notes = "게시글 수정 API")
    public ResponseEntity updateBoard(Long boardId, String title, String contents) throws Exception{
        return new ResponseEntity(boardService.updateBoard(boardId,title,contents), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 API")
    public ResponseEntity deleteBoard(@RequestBody Long boardId) throws Exception{
        return new ResponseEntity(boardService.deleteBoard(boardId),HttpStatus.OK);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    @ApiOperation(value="게시글 목록 보기", notes="게시글 목록 API")
    public ResponseEntity getBoardList(int page) throws Exception{
        return new ResponseEntity(boardService.getBoardList(page), HttpStatus.OK);
    }

    @RequestMapping(value="comments", method = RequestMethod.GET)
    @ApiOperation(value="게시글 댓글 불러오기", notes = "게시글 댓글 불러오기 API")
    public ResponseEntity readComments(Long boardId) throws Exception{
        return new ResponseEntity(boardService.getComments(boardId),HttpStatus.OK);
    }

    @RequestMapping(value="search/{title}", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 제목으로 검색", notes = "게시글 제목으로 검색 API")
    public ResponseEntity searchBoardToTitle(int page, String title) throws Exception{
        return new ResponseEntity(boardService.searchBoardToTitle(page, title), HttpStatus.OK);
    }
    @RequestMapping(value="search/{contents}", method = RequestMethod.GET)
    @ApiOperation(value = "게시글 내용으로 검색", notes = "게시글 내용으로 검색 API")
    public ResponseEntity searchBoardToContents(int page, String contents) throws Exception{
        return new ResponseEntity(boardService.searchBoardToTitle(page, contents), HttpStatus.OK);
    }
}
