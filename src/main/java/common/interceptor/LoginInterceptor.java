package common.interceptor;

import domain.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import service.MemberService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String LOGIN = "login";
    private static final String COOKIE = "Cookie";

    @Autowired
    private MemberService memberService;
    // 로그인 전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        // 기존의 로그인 정보 제거
        if(httpSession.getAttribute(LOGIN) != null) httpSession.removeAttribute(LOGIN);
        return true;
    }
    // 로그인 후
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HttpSession httpSession = request.getSession(); // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
        ModelMap modelMap = modelAndView.getModelMap();
        Object object = modelMap.get("member");

        if(object != null) {
            httpSession.setAttribute(LOGIN, object); // 로그인 후 세션 생성
            MemberDto memberDto = (MemberDto) object;
            if(request.getParameter(COOKIE) != null){
                // 자동 로그인을 위한 쿠키 생성
                Cookie loginCookie = new Cookie("loginCookie", httpSession.getId());
                int amount = 60 * 60 * 24;
                loginCookie.setMaxAge(amount);    // 기간 하루
                Date sessionLimit = new Date(System.currentTimeMillis()+(1000*amount));
                memberService.keepLogin(memberDto.getEmail(), httpSession.getId(), sessionLimit);
                // 전송
                response.addCookie(loginCookie);
            }
        }
    }
}
