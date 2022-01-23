package controller;

import annotation.ValidationGroups;
import domain.dto.MemberDto;
import domain.dto.TestDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.MemberService;
import service.TestService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TestService testService;

    @RequestMapping(value="/members/join",method = RequestMethod.GET)
    public String join(){
        return "members/join";
    }

    //Mapper Test
    @RequestMapping(value="test", method = RequestMethod.POST)
    @ApiOperation(value="Mapper Test", notes ="DB Test")
    public ResponseEntity test(@RequestBody TestDto testDto)throws Exception{
        return new ResponseEntity((testService.test(testDto)),HttpStatus.OK);
    }
    // 회원가입
    @RequestMapping(value = "join", method = RequestMethod.POST)
    @ApiOperation(value = "회원가입", notes = "회원가입 API")
    public ResponseEntity create(@RequestBody @Validated(ValidationGroups.join.class) MemberDto memberDto) throws Exception {
        return new ResponseEntity(memberService.join(memberDto), HttpStatus.OK);
    }
}
