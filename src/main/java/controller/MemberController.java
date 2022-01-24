package controller;

import annotation.ValidationGroups;
import domain.dto.LoginDto;
import domain.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import response.BaseResponse;
import service.MemberService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원가입
    @RequestMapping(value = "join", method = RequestMethod.POST)
    @ApiOperation(value = "회원가입", notes = "회원가입 API")
    public ResponseEntity create(@RequestBody @Validated(ValidationGroups.join.class) MemberDto memberDto) throws Exception {
        return new ResponseEntity(memberService.join(memberDto), HttpStatus.OK);
    }
    // 로그인
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value="로그인", notes = "로그인 API")
    public ResponseEntity login(@RequestBody LoginDto loginDto, HttpServletRequest request, Model model) throws Exception{
        HttpSession httpSession = request.getSession();
        Object member = httpSession.getAttribute("login");
        if(member != null) return new ResponseEntity(new BaseResponse("쿠키를 통한 자동 로그인", HttpStatus.OK),HttpStatus.OK);

        MemberDto memberDto = memberService.login(loginDto);
        model.addAttribute("member", memberDto);
        return new ResponseEntity(new BaseResponse("로그인 성공", HttpStatus.OK), HttpStatus.OK);
    }

    @RequestMapping(value="logout", method = RequestMethod.POST)
    @ApiOperation(value="로그아웃", notes = "로그아웃 및 세션 쿠키 삭제")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)throws Exception{
        Object object = httpSession.getAttribute("login");
        if(object != null){
            MemberDto memberDto = (MemberDto)object;
            httpSession.removeAttribute("login");
            httpSession.invalidate();
            Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
            if(loginCookie != null){
                loginCookie.setMaxAge(0);
                response.addCookie(loginCookie);
                memberService.keepLogin(memberDto.getEmail(), "none", new Date());
            }
        }
        return new ResponseEntity("로그아웃 및 쿠키 삭제", HttpStatus.OK);
    }

}
