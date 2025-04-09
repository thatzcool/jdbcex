package com.ssg.jdbcex.todo.filter;


import com.ssg.jdbcex.todo.dto.MemberDTO;
import com.ssg.jdbcex.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       log.info("Login.........doFilter..");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") != null) {
            chain.doFilter(request, response);
            return;
        }

        //session 에 loginInfo 값이 없다면
        //쿠키를 체크
        Cookie cookie = findCookie(req.getCookies(),"remember-me");

        //세션에도 없고  쿠키도 없다면 그냥 로그인 으로 보내자
        if(cookie == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        //쿠기가 존재하는 상황
          log.info("...cookie가 있는 상황....");
          String uuid = cookie.getValue();

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.getByUuid(uuid);
            log.info("쿠키의 값으로 조회한 사용자 정보" + memberDTO);

            if(memberDTO == null) {
                throw new Exception("Cookie value is not valid.");
            }
            //회원 정보를 세션에 추가
            session.setAttribute("loginInfo", memberDTO);
            chain.doFilter(request, response);

        } catch (Exception e) {
           e.printStackTrace();
           resp.sendRedirect(req.getContextPath() + "/login");
        }


    }

    private Cookie findCookie(Cookie[] cookies, String s) {
        if(cookies == null || s.length() == 0) {
            return null;
        }
        Optional<Cookie> result = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(s)).findFirst();
        return result.isPresent() ? result.get() : null;
    }
}
