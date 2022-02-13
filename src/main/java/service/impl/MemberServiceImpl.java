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
import service.AuthService;
import service.MemberService;

import javax.servlet.http.HttpSession;
import java.util.Date;
/*
    회원가입, 로그인 세션
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private AuthService authService;

    @Override
    public BaseResponse join(MemberDto memberDto) throws MyException{
        // 중복체크
        checkExistEmail(memberDto);
        checkExistNickName(memberDto);

        // 비밀번호 암호화 - 단방향 해시
        memberDto.setPassword(BCrypt.hashpw(memberDto.getPassword(), BCrypt.gensalt()));
        memberMapper.join(memberDto);  // 회원 가입
        return new BaseResponse("회원가입에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public MemberDto login(LoginDto loginDto) throws MyException {
        if(authService.checkLogin() != null)
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "이미 로그인 되어있습니다. 로그아웃을 먼저 해주세요");
        // 비밀번호는 암호화 처리를 했으므로 따로 검증처리함.
        MemberDto memberDto = memberMapper.getUserInfoToEmail(loginDto.getEmail());

        if(memberDto == null || memberDto.getPassword() == null || memberDto.getEmail() == null)
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "존재하지 않는 회원이거나, 이메일 혹은 비밀번호가 잘못되었습니다.");

        if(BCrypt.checkpw(loginDto.getPassword(), memberDto.getPassword())){
            // 로그인 성공
            return memberDto;
        }
        else throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST,"잘못된 비밀번호입니다.");
    }
    @Override
    public MemberDto getMember(String email) {
        return memberMapper.getUserInfoToEmail(email);
    }

    @Override
    public BaseResponse updateMember(MemberDto memberDto, HttpSession httpSession) throws Exception {
        // 로그인한 상태에서만 본인 정보를 업데이트
        MemberDto memberDto1 = authService.authMember();
        if (memberDto1.getEmail().equals(memberDto.getEmail())){
            if(memberDto1.getNickName().equals(memberDto.getNickName())) ;
            else checkExistNickName(memberDto);
        }
        else if(memberDto1.getNickName().equals(memberDto.getNickName())){
            checkExistEmail(memberDto);
        }
        memberDto.setId(memberDto1.getId());
        memberMapper.updateMember(memberDto);
        // 회원 정보 수정 시 로그아웃 -> 변경사항 적용을 위해 재 로그인
        httpSession.removeAttribute("login");
        httpSession.invalidate();
        return new BaseResponse("회원정보 수정 완료", HttpStatus.OK);
    }

    @Override
    public BaseResponse deleteMember(LoginDto loginDto, HttpSession httpSession) throws MyException {
        MemberDto memberDto =authService.authMember();
        if(memberDto.getEmail().equals(loginDto.getEmail()) && BCrypt.checkpw(loginDto.getPassword(), memberDto.getPassword()))
            memberMapper.deleteMember(memberDto.getId());
        else throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST,"본인만 회원 탈퇴를 진행할 수 있습니다.");
        // 탈퇴 시 로그아웃
        httpSession.removeAttribute("login");
        httpSession.invalidate();
        return new BaseResponse("회원 탈퇴 완료", HttpStatus.OK);
    }

    private void checkExistEmail(MemberDto memberDto) throws MyException{
        // 이메일 중복체크
        if (memberMapper.checkExistEmail(memberDto.getEmail()))
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "이메일 중복");
    }
    private void checkExistNickName(MemberDto memberDto) throws MyException{
        // 닉네임 중복체크
        if (memberMapper.checkExistNickName(memberDto.getNickName()))
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "닉네임 중복");
    }

    // 로그인 유지
    @Override
    public void keepLogin(String email, String sessionId, Date limitDate) throws Exception {
        memberMapper.setSession(sessionId,limitDate,email);
    }
}