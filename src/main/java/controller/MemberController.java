package controller;

import annotation.ValidationGroups;
import domain.dto.LoginDto;
import domain.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import response.BaseResponse;
import service.AuthService;
import service.MemberService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private AuthService authService;

    // 회원가입
    @RequestMapping(value = "join", method = RequestMethod.POST)
    @ApiOperation(value = "회원가입", notes = "회원가입 API")
    public ResponseEntity create(@RequestBody @Validated(ValidationGroups.join.class) MemberDto memberDto) throws Exception {
        return new ResponseEntity(memberService.join(memberDto), HttpStatus.OK);
    }

    // 로그인
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value="로그인", notes = "로그인 API")
    public ResponseEntity login(@RequestBody LoginDto loginDto) throws Exception{
        return new ResponseEntity(memberService.login(loginDto), HttpStatus.OK);
    }

    @RequestMapping(value="logout", method = RequestMethod.POST)
    @ApiOperation(value="로그아웃", notes = "로그아웃 및 세션 쿠키 삭제")
    public ResponseEntity logout()throws Exception{
        return new ResponseEntity(memberService.logout(), HttpStatus.OK);
    }
/*
    회원탈퇴, 회원수정, 회원정보
 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value="회원정보 보기", notes = "회원정보 보기 API")
    public ResponseEntity getMember() throws Exception{
        MemberDto memberDto = authService.authMember();
        return new ResponseEntity(new BaseResponse(memberDto.toString(),HttpStatus.OK),HttpStatus.OK);
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    @ApiOperation(value="회원 탈퇴", notes = "회원 탈퇴 API")
    public ResponseEntity deleteMember(@RequestBody LoginDto loginDto, HttpSession httpSession) throws Exception{
        return new ResponseEntity(memberService.deleteMember(loginDto, httpSession),HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "회원정보 수정", notes = "회원정보 수정 API")
    public ResponseEntity updateMember(@RequestBody @Validated(ValidationGroups.join.class) MemberDto memberDto, HttpSession httpSession) throws Exception{
        return new ResponseEntity(memberService.updateMember(memberDto, httpSession),HttpStatus.OK);

    }
}
