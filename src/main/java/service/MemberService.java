package service;

import domain.dto.LoginDto;
import domain.dto.MemberDto;
import response.BaseResponse;

import javax.servlet.http.HttpSession;

public interface MemberService {
    BaseResponse join(MemberDto member) throws Exception;
    BaseResponse login(LoginDto loginDto) throws Exception;
    BaseResponse logout() throws Exception;
    MemberDto getMember(String email);
    BaseResponse updateMember(MemberDto memberDto, HttpSession httpSession) throws Exception;
    BaseResponse deleteMember(LoginDto loginDto, HttpSession httpSession) throws Exception;
}
