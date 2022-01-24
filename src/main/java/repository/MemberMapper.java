package repository;

import domain.dto.MemberDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MemberMapper {
    /*
        회원가입
     */
    void join(@Param(value = "memberDto") MemberDto memberDto);
    /*
        회원가입 시 중복 체크
     */
    boolean checkExistEmail(@Param(value = "email") String email);
    boolean checkExistNickName(@Param(value ="nick_name")String nick_name);
    /*
        로그인 시 세션 관리
     */
    MemberDto getUserInfoToEmail(@Param(value="email") String email);
    MemberDto getUserInfoToSession(@Param(value = "session")String session);
    void setSession(@Param(value="session_key") String sessionKey, @Param(value="limitDate") Date sessionLimit, @Param(value="email") String email);

    /*

     */

    //
//    void setAge(Long uid, int age);
//
//    void setSex(Long uid, int sex);
//
//    void setPhone(Long uid, String phone_number);
//
//    void setAddress(Long uid, String address);
//
//    short getUserNumToEmail(String email);
//
//    short getUserNumToNickName(String nickname);
//
//    MemberDto getUserToEmail(String email);
//
//    String getSaltToUid(Long uid);
//
//    Long getUidToEmail(String email);
//
//    String getPasswordToEmail(String email);
//
//    void setSalt(Long uid, String salt);
}
