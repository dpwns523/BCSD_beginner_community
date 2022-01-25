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
    public ResponseEntity create(@RequestBody @Validated(ValidationGroups.createBoard.class) BoardDto boardDto) throws Exception{
        return new ResponseEntity(boardService.createBoard(boardDto), HttpStatus.OK);
    }
}
