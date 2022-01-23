package service.impl;

import common.Constants;
import common.exception.MyException;
import domain.dto.MemberDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import repository.MemberMapper;
import response.BaseResponse;
import service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public BaseResponse join(MemberDto memberDto) throws MyException{
        // 이메일 중복체크
        if (memberMapper.checkExistEmail(memberDto.getEmail()))
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "이메일 중복");

        // 닉네임 중복체크
        if (memberMapper.checkExistNickName(memberDto.getNick_name()))
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "닉네임 중복");

        // 비밀번호 암호화
        memberDto.setPassword(BCrypt.hashpw(memberDto.getPassword(), BCrypt.gensalt()));
        memberMapper.join(memberDto);  // 회원 가입
//        try {
//
//        } catch (Exception ex) {
//            return new BaseResponse("회원가입에 실패하였습니다.", HttpStatus.BAD_REQUEST);
//        }
//
//        // salt 설정을 위한 uid
//        Long id = memberMapper.getUidToEmail(memberDto.getEmail());
//
//        // salt 생성 날짜
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        String salt = id.toString() + calendar.getTime();
//
//        salt = (BCrypt.hashpw(salt, BCrypt.gensalt()));
//        memberMapper.setSalt(id, salt);
        return new BaseResponse("회원가입에 성공했습니다.", HttpStatus.OK);
    }

    @Override
    public MemberDto getMember(String uid) {
        return null;
    }
}