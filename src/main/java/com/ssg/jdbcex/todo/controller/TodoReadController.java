package com.ssg.jdbcex.todo.controller;

import lombok.extern.log4j.Log4j2;
import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Long tno = Long.parseLong(req.getParameter("tno"));

            TodoDTO todoDTO = todoService.get(tno);

            //모델 담기
            req.setAttribute("dto", todoDTO);

            //cookie 찾기
            Cookie viewTodoCookie  = findCookie(req.getCookies(),"viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exists = false;
            if(todoListStr != null && todoListStr.indexOf(tno+"-") >= 0){
                exists = true;
            }

            log.info("exists:" + exists);

            if(!exists){
                todoListStr += tno+"-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60*60*24);
                viewTodoCookie.setPath("/");
                resp.addCookie(viewTodoCookie);
                }


            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);

        }catch(Exception e){
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
            Cookie cookie = null;

            if(cookies != null && cookies.length > 0) {
                for(Cookie c : cookies){
                    if(c.getName().equals(cookieName)){
                         cookie = c;
                         break;
                    }
                }
            }
            if(cookie == null){
                cookie = new Cookie(cookieName, "");
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24);

                            }
        return cookie;
    }

}

