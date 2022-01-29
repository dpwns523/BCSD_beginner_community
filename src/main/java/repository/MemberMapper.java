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
    boolean checkExistNickName(@Param(value ="nickName")String nickName);
    /*
        로그인 시 세션 관리
     */
    MemberDto getUserInfoToEmail(@Param(value="email") String email);
    MemberDto getUserInfoToSession(@Param(value = "session")String session);
    void setSession(@Param(value="session_key") String sessionKey, @Param(value="limitDate") Date sessionLimit, @Param(value="email") String email);

    /*
        회원 정보 수정, 삭제
     */
    void updateMember(@Param(value="memberDto")MemberDto memberDto);
    void deleteMember(@Param(value="id")Long id);
}
