package com.ssg.jdbcex.todo.service;

import com.ssg.jdbcex.todo.dto.TodoDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * packageName   : com.ssg.w1.todo.service
 * fileName      : TodoService
 * author        : a
 * date          : 2025-04-07
 * description   :
 * =================================================
 * DATE             AUTHOR             NOTE
 * -------------------------------------------------
 * 2025-04-07        a
 */
public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG.........." + todoDTO);
    }
   //Todo 전체 리스트 반환 기능
    public List<TodoDTO> getList() {

        List<TodoDTO> todoDTOList = IntStream.range(0, 10).mapToObj(i -> {
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setTno((long) i);
            todoDTO.setTitle("Todo.." + i);
            todoDTO.setDueDate(LocalDateTime.now());

            return todoDTO;

        }).collect(Collectors.toList());

        return todoDTOList;

    }
    // 사용자 선택한 Todo 1개 반환
      public TodoDTO get(Long tno){
           TodoDTO dto = new TodoDTO();
           dto.setTno(tno);
           dto.setDueDate(LocalDateTime.now());
           dto.setTitle("Sample Dto");
           dto.setFinished(true);
        return dto;
      }


}

//enum 타입은 정해진 수만큼 객체를 생성할 수 있다.
