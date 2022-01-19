package service.impl;

import domain.dto.MemberDto;
import domain.entity.MemberEntity;
import handler.MemberDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import response.BaseResponse;
import service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    MemberDataHandler memberDataHandler;

    @Autowired
    public MemberServiceImpl(MemberDataHandler memberDataHandler){
        this.memberDataHandler = memberDataHandler;
    }

    @Override
    public BaseResponse join(MemberDto memberDto) throws Exception {
        return memberDataHandler.joinMemberEntity(memberDto);   // Dto를 가지고 Entity 생성
    }

    @Override
    public MemberDto getMember(String uid) {
        MemberEntity memberEntity = memberDataHandler.getProductEntity(uid);
        return null;
    }
}