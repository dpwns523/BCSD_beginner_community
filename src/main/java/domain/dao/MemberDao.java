package domain.dao;

import domain.entity.MemberEntity;
import response.BaseResponse;

public interface MemberDao {
    BaseResponse saveMember(MemberEntity member);

    MemberEntity getMember(String uid);
}
