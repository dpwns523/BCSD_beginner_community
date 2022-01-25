package service.impl;

import common.Constants;
import common.exception.MyException;
import domain.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private HttpServletRequest request;

    @Override
    public MemberDto authMember() throws MyException {
        HttpSession httpSession = request.getSession();
        Object object = httpSession.getAttribute("login");
        if(object == null)
            throw new MyException(Constants.ExceptionClass.MEMBER, HttpStatus.BAD_REQUEST, "로그인이 필요합니다.");
        return (MemberDto)object;
    }
}
