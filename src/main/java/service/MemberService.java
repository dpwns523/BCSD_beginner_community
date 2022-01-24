package service;

import domain.dto.LoginDto;
import domain.dto.MemberDto;
import response.BaseResponse;

import java.util.Date;

public interface MemberService {
    BaseResponse join(MemberDto member) throws Exception;
    MemberDto login(LoginDto loginDto) throws Exception;
    void keepLogin(String email, String sessionId, Date limitDate) throws Exception;
    MemberDto getMember(String uid);

//    Map<String, Object> checkKey(String key) throws Exception;
//
//    Map<String, String> login(Member member) throws Exception;
//
//    Map<String, String> refresh() throws Exception;
}
