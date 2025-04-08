package com.ssg.service;


import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void setUp() {
        todoService = TodoService.INSTANCE;
    }
       @Test
    public void testRegister()throws Exception {
        TodoDTO todoDTO = TodoDTO.builder().title("Sample Test Mapper Register todovo2")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();
           todoService.register(todoDTO);
               }

}
