package com.ssg.dao;


import com.ssg.jdbcex.todo.dao.TodoDAO;
import com.ssg.jdbcex.todo.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalTime.now;

public class TodoDAOTests {
    private TodoDAO todoDAO;
    private TodoVO todoVO;

    @BeforeEach
    public void ready1() {
        todoDAO = new TodoDAO();

    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO vo = TodoVO.builder().title("Sample Test todovo1").dueDate(LocalDate.now()).build();
        todoDAO.insert(vo);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> voList = todoDAO.selectAll();
        voList.forEach(System.out::println);


    }

}
