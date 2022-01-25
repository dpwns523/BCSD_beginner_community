package service;

import common.exception.MyException;
import domain.dto.MemberDto;

public interface AuthService {
    MemberDto authMember() throws MyException;
}
