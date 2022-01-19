package service;

import domain.dto.MemberDto;
import response.BaseResponse;

public interface MemberService {
    BaseResponse join(MemberDto member) throws Exception;

    MemberDto getMember(String uid);

//    Map<String, Object> checkKey(String key) throws Exception;
//
//    Map<String, String> login(Member member) throws Exception;
//
//    Map<String, String> refresh() throws Exception;
}
