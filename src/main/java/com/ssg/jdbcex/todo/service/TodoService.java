package com.ssg.jdbcex.todo.service;

import com.ssg.jdbcex.todo.dao.TodoDAO;
import com.ssg.jdbcex.todo.domain.TodoVO;
import com.ssg.jdbcex.todo.dto.TodoDTO;
import com.ssg.jdbcex.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;

    //todoDAO 와 Service 연결
    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }


    public void register(TodoDTO todoDTO) throws SQLException {
       // System.out.println("DEBUG.........." + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        //System.out.println("todoVoO : " + todoVO);
        dao.insert(todoVO);
    }


    //Todo 전체 리스트 반환 기능
    public List<TodoDTO> getList() {

        List<TodoDTO> todoDTOList = IntStream.range(0, 10).mapToObj(i -> {
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setTno((long) i);
            todoDTO.setTitle("Todo.." + i);
            todoDTO.setDueDate(LocalDate.now());

            return todoDTO;

        }).collect(Collectors.toList());

        return todoDTOList;

    }

    // 사용자 선택한 Todo 1개 반환
    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setDueDate(LocalDate.now());
        dto.setTitle("Sample Dto");
        dto.setFinished(true);
        return dto;
    }


}

//enum 타입은 정해진 수만큼 객체를 생성할 수 있다.
