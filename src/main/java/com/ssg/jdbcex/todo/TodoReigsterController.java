package com.ssg.jdbcex.todo;
/**
 * packageName   : com.ssg.w1.todo
 * fileName      : TodoReigsterController
 * author        : a
 * date          : 2025-04-07
 * description   :
 * =================================================
 * DATE             AUTHOR             NOTE
 * -------------------------------------------------
 * 2025-04-07        a
 */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReigsterController" , urlPatterns = "/todo/register")
public class TodoReigsterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet 입력화면 볼 수 있도록 구성");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동할꺼야");

        response.sendRedirect("/todo/list");
    }
}