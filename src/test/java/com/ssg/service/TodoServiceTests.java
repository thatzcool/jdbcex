package com.ssg.service;


import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalDate.*;

@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void setUp() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder().title("Sample Test Mapper Register todovo4")
                .dueDate(LocalDate.of(2025, 4, 9))
                .build();
        log.info(todoDTO);
        todoService.register(todoDTO);

        log.info("==================================");


    }

}
