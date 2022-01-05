package repository;

import domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    void join(Member member);

    void setAge(Long uid, int age);

    void setSex(Long uid, int sex);

    void setPhone(Long uid, String phone_number);

    void setAddress(Long uid, String address);

    short getUserNumToEmail(String email);

    short getUserNumToNickName(String nickname);

    Member getUserToEmail(String email);

    String getSaltToUid(Long uid);

    Long getUidToEmail(String email);

    String getPasswordToEmail(String email);

    void setSalt(Long uid, String salt);

}
