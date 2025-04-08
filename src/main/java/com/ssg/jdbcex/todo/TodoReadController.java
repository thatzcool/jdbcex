package com.ssg.jdbcex.todo;
/**
 * packageName   : com.ssg.w1.todo
 * fileName      : TodoReadController
 * author        : a
 * date          : 2025-04-08
 * description   :
 * =================================================
 * DATE             AUTHOR             NOTE
 * -------------------------------------------------
 * 2025-04-08        a
 */

import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/todoReadController" , urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet ....Read.........");
        Long tno = Long.parseLong(request.getParameter("tno"));
        TodoDTO dto = TodoService.INSTANCE.get(tno);
        request.setAttribute("dto", dto);
        request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}