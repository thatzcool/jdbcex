package com.ssg.jdbcex.todo.listener;


import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.awt.event.ActionListener;

@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
          String name = event.getName();
          Object value = event.getValue();

          if(name.equals("loginInfo")){
              log.info(" user logined.......");
              log.info(value);
          }
    }
}

