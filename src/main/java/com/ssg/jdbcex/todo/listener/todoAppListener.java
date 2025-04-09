package com.ssg.jdbcex.todo.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
public class todoAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized");
        log.info("contextInitialized");
        log.info("contextInitialized");

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("appName","todoService");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed");
        log.info("contextDestroyed");
        log.info("contextDestroyed");
    }
}
