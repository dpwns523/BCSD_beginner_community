//package domain.dao.impl;
//
//import domain.dao.MemberDao;
//import domain.entity.MemberEntity;
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import repository.MemberMapper;
//import response.BaseResponse;
//
//import java.util.Calendar;
//import java.util.Date;
//
//@Service
//public class MemberDaoImpl implements MemberDao {
//
//    @Autowired
//    private MemberMapper memberMapper;
//
//    public MemberDaoImpl(MemberMapper memberMapper) {
//        this.memberMapper = memberMapper;
//    }
//
//    @Override
//    public BaseResponse saveMember(MemberEntity memberEntity){
//        // 이메일 중복체크
//        if (memberMapper.getUserNumToEmail(memberEntity.getEmail()) != 0)
//            return new BaseResponse("이미 존재하는 이메일입니다.", HttpStatus.BAD_REQUEST);
//
//        // 닉네임 중복체크
//        if (memberMapper.getUserNumToNickName(memberEntity.getNickName()) != 0)
//            return new BaseResponse("이미 존재하는 닉네임입니다.", HttpStatus.BAD_REQUEST);
//
//        // 비밀번호 암호화
//        memberEntity.setPassword(BCrypt.hashpw(memberEntity.getPassword(), BCrypt.gensalt()));
//
//        try {
//            memberMapper.join(memberEntity);  // 회원 가입
//        } catch (Exception ex) {
//            return new BaseResponse("회원가입에 실패하였습니다.", HttpStatus.BAD_REQUEST);
//        }
//
//        // salt 설정을 위한 uid
//        Long id = memberMapper.getUidToEmail(memberEntity.getEmail());
//
//        // salt 생성 날짜
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        String salt = id.toString() + calendar.getTime();
//
//        salt = (BCrypt.hashpw(salt, BCrypt.gensalt()));
//        memberMapper.setSalt(id, salt);
//        return new BaseResponse("회원가입에 성공했습니다.", HttpStatus.OK);
//    }
//
//    @Override
//    public MemberEntity getMember(String uid) {
//        return null;
//    }
//}
