package com.ssg.jdbcex.todo.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        String str = mid+mpwd;
        HttpSession session = req.getSession();
        session.setAttribute("loginInfo", str);
        resp.sendRedirect(req.getContextPath() + "/todo/list");

    }
}
