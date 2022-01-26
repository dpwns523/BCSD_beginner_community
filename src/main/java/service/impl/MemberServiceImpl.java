package service.impl;

import common.Constants;
import common.exception.MyException;
import domain.dto.LoginDto;
import domain.dto.MemberDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.MemberMapper;
import response.BaseResponse;
import service.MemberService;

import java.util.Date;
/*
    회원가입, 로그인 세션
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public BaseResponse join(MemberDto memberDto) throws MyException{
        // 이메일 중복체크
        if (memberMapper.checkExistEmail(memberDto.getEmail()))
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "이메일 중복");

        // 닉네임 중복체크
        if (memberMapper.checkExistNickName(memberDto.getNick_name()))
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "닉네임 중복");

        // 비밀번호 암호화 - 단방향 해시
        memberDto.setPassword(BCrypt.hashpw(memberDto.getPassword(), BCrypt.gensalt()));
        memberMapper.join(memberDto);  // 회원 가입
        return new BaseResponse("회원가입에 성공했습니다.", HttpStatus.OK);
    }
    @Override
    public MemberDto getMember(String uid) {
        return null;
    }

    @Override
    public MemberDto login(LoginDto loginDto) throws MyException {
        // 비밀번호는 암호화 처리를 했으므로 따로 검증처리함.
        MemberDto memberDto = memberMapper.getUserInfoToEmail(loginDto.getEmail());

        if(memberDto == null || memberDto.getPassword() == null || memberDto.getEmail() == null)
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "존재하지 않는 회원이거나, 이메일 혹은 비밀번호가 잘못되었습니다.");

        if(BCrypt.checkpw(loginDto.getPassword(), memberDto.getPassword())){
            // 세션발급, 로그인 성공
            // 로그인 성공 처리
            return memberDto;
        }
        else throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST,"잘못된 비밀번호입니다.");
    }

    @Override
    public void keepLogin(String email, String sessionId, Date limitDate) throws Exception {
        memberMapper.setSession(sessionId,limitDate,email);
    }
}