package com.ssg.jdbcex.todo.controller;

import com.ssg.jdbcex.todo.dto.MemberDTO;
import com.ssg.jdbcex.todo.service.MemberService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get...........");
        req.getRequestDispatcher("/WEB-INF/todo/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post...........");
        String mid = req.getParameter("mid");
        String mpwd = req.getParameter("mpwd");
        String auto = req.getParameter("auto");

        boolean rememberMe = auto != null && auto.equals("on");
        if(rememberMe){
            String uuid = UUID.randomUUID().toString();
        }
//        String str = mid+mpwd;

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid,mpwd);

            if(rememberMe){
                String uuid = UUID.randomUUID().toString();
                MemberService.INSTANCE.updateUuid(mid,uuid);
                memberDTO.setUuid(uuid);
            }


            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect(req.getContextPath() + "/todo/list");
        } catch (Exception e) {
           resp.sendRedirect(req.getContextPath() + "/login?result=error");
        }


    }
}
