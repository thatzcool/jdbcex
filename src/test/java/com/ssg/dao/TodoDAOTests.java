package com.ssg.dao;


import com.ssg.jdbcex.todo.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }
    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime2());
    }
}
