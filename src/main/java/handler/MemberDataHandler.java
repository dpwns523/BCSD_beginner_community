package handler;

import domain.dto.MemberDto;
import domain.entity.MemberEntity;
import response.BaseResponse;

public interface MemberDataHandler {
    /*
        MemberDto의 getter로 데이터를 넘겨 Entity 변환 vs 객체를 넘겨서 Entity로 변환
     */
    BaseResponse joinMemberEntity(MemberDto memberDto);

    MemberEntity getProductEntity(String productId);

}
