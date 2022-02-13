package service;

import domain.dto.LoginDto;
import domain.dto.MemberDto;
import response.BaseResponse;

import javax.servlet.http.HttpSession;
import java.util.Date;

public interface MemberService {
    BaseResponse join(MemberDto member) throws Exception;
    MemberDto login(LoginDto loginDto) throws Exception;
    MemberDto getMember(String email);
    BaseResponse updateMember(MemberDto memberDto, HttpSession httpSession) throws Exception;
    BaseResponse deleteMember(LoginDto loginDto, HttpSession httpSession) throws Exception;
    void keepLogin(String email, String sessionId, Date limitDate) throws Exception;
}
