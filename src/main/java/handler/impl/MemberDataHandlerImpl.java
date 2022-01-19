package handler.impl;

import domain.dao.MemberDao;
import domain.dto.MemberDto;
import domain.entity.MemberEntity;
import handler.MemberDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import response.BaseResponse;

@Service
public class MemberDataHandlerImpl implements MemberDataHandler {

    MemberDao memberDao;

    @Autowired
    public MemberDataHandlerImpl(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    @Override
    public BaseResponse joinMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity(memberDto.getName(), memberDto.getPassword(),
                memberDto.getNickName(), memberDto.getEmail(),
                memberDto.getPhoneNumber(), memberDto.getAge(), memberDto.getSex());
        return memberDao.saveMember(memberEntity);
    }

    @Override
    public MemberEntity getProductEntity(String productId) {
        return null;
    }
}
