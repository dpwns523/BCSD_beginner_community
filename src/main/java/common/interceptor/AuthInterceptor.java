package common.interceptor;

import domain.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import repository.MemberMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
   쿠키를 활용한 권한 체크
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
        if(loginCookie != null){    // 로그인 쿠키를 가지고 있다면 정보를 이용해 사용자 정보가 존재하는지 확인한다.
            MemberDto memberDto =memberMapper.getUserInfoToSession(loginCookie.getValue());
            if(memberDto != null) httpSession.setAttribute("login", memberDto);
        }
        System.out.println("AuthInterceptor 작동");

        return true;
    }
}
