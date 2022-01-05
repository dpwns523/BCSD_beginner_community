package controller;

import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.MemberServiceImpl;

@Controller
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @RequestMapping(value="/members/join",method = RequestMethod.GET)
    public String join(){
        return "members/join";
    }
    // 회원가입
    @RequestMapping(value = "/members/join", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody @Validated(Member.class) Member member) throws Exception{
        return new ResponseEntity(memberService.join(member), HttpStatus.OK);
    }
//    @RequestMapping(value="/members/join",method = RequestMethod.POST)
//    public String create(@Validated(Member.class)Member member) throws Exception {
//        memberService.join(member);
//        return "hello";
//    }

}
