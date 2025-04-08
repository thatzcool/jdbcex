package com.ssg.jdbcex.todo.dao;

import com.ssg.jdbcex.todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.*;
import java.time.LocalDateTime;

//DB 로 부터 시간 얻어오는 간단한 기능 구현
public class TodoDAO {

    public String getTime() {

        String now = null;
        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("select now()");
            ResultSet rs = ps.executeQuery();){
              rs.next();
              now =rs.getString(1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws SQLException {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }

    //tbl_todo 테이블에 todo를 넣는 insert(TodoVO vo)
    public void insert(TodoVO vo) throws SQLException {
        // 쿼리문
        String sql = "insert into tbl_todo(title,dueDate,finished) values(?,?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = ConnectionUtil.INSTANCE.getConnection().prepareStatement(sql);

        ps.setString(1, vo.getTitle());
        ps.setDate(2, Date.valueOf(vo.getDueDate().toLocalDate()));
        ps.setBoolean(3, vo.isFinished());

        ps.executeUpdate();

    }

}
