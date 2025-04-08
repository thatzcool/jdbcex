package com.ssg.jdbcex.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDateTime dueDate;
    private boolean finished;
}
