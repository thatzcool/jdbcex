package com.ssg.jdbcex.todo.dto;

import java.time.LocalDateTime;

/**
 * packageName   : com.ssg.w1.todo.dto
 * fileName      : TodoDTO
 * author        : a
 * date          : 2025-04-07
 * description   :
 * =================================================
 * DATE             AUTHOR             NOTE
 * -------------------------------------------------
 * 2025-04-07        a
 */
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDateTime dueDate;
    private boolean finished;

    public Long getTno() {
        return tno;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "tno=" + tno +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", finished=" + finished +
                '}';
    }
}
