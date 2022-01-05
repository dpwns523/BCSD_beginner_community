package service;

import domain.Member;
import response.BaseResponse;
import java.util.Map;

public interface MemberService {
    BaseResponse join(Member member) throws Exception;

//    Map<String, Object> checkKey(String key) throws Exception;
//
//    Map<String, String> login(Member member) throws Exception;
//
//    Map<String, String> refresh() throws Exception;
}
