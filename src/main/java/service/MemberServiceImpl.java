package service;

import domain.Member;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import repository.MemberMapper;
import response.BaseResponse;
//import util.Jwt;


import javax.servlet.http.HttpServletRequest;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

//    @Autowired
//    private Jwt jwt;

    @Override
    public BaseResponse join(Member member) throws Exception {
        // 이메일 중복체크
        if (memberMapper.getUserNumToEmail(member.getEmail()) != 0)
            return new BaseResponse("이미 존재하는 이메일입니다.", HttpStatus.OK);

        // 닉네임 중복체크
        if (memberMapper.getUserNumToNickName(member.getNickName()) != 0)
            return new BaseResponse("이미 존재하는 닉네임입니다.", HttpStatus.OK);

        // 비밀번호 암호화
        member.setPassword(BCrypt.hashpw(member.getPassword(), BCrypt.gensalt()));
        try {
            memberMapper.join(member);  // 회원 가입
        } catch (Exception ex) {
            return new BaseResponse("회원가입에 실패하였습니다.", HttpStatus.OK);
        }

        // salt 설정을 위한 uid
        Long id = memberMapper.getUidToEmail(member.getEmail());

        // salt 생성 날짜
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String salt = id.toString() + calendar.getTime();

        salt = (BCrypt.hashpw(salt, BCrypt.gensalt()));
        memberMapper.setSalt(id, salt);

        return new BaseResponse("회원가입에 성공했습니다.", HttpStatus.OK);
    }

}