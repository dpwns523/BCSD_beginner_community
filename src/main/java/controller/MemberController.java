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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private HttpServletRequest request;

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
        //Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
        MemberDto memberDto = memberService.login(loginDto);
        //model.addAttribute("member", memberDto); // 인터셉터 postHandle
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("login",memberDto);
        System.out.println("Login {"+memberDto+"}");
        return new ResponseEntity(new BaseResponse("로그인 성공, 세션 발급", HttpStatus.OK), HttpStatus.OK);
    }

    @RequestMapping(value="logout", method = RequestMethod.POST)
    @ApiOperation(value="로그아웃", notes = "로그아웃 및 세션 쿠키 삭제")
    public ResponseEntity logout(HttpSession httpSession)throws Exception{
        MemberDto memberDto = authService.authMember();
        System.out.println("logout {"+memberDto+"}");
        httpSession.removeAttribute("login");
        httpSession.invalidate();
//        TODO: 자동 로그인 구현 시 쿠키 활용
//        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
//        if(loginCookie != null){
//            loginCookie.setMaxAge(0);
//            response.addCookie(loginCookie);
//            memberService.keepLogin(memberDto.getEmail(), "none", new Date());
//        }
        return new ResponseEntity(new BaseResponse("로그아웃 및 세션 삭제", HttpStatus.OK), HttpStatus.OK);
    }
/*
    회원탈퇴, 회원수정, 회원정보
 */

}
