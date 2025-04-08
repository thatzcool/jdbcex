package com.ssg.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTests {
    @Test
    public void test1() {
        int v1 = 10;
        int v2 = 10;
        Assertions.assertEquals(v1, v2);
    }


     @Test
    public void test2() throws SQLException , ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/____?serverTimezone=UTC";
        String username = "____";
        String password = "____";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,username,password);
        Assertions.assertNotNull(conn);
        conn.close();

     }

     @Test
     public void test3() throws SQLException , ClassNotFoundException {
         HikariConfig config = new HikariConfig();
         config.setDriverClassName("com.mysql.cj.jdbc.Driver");
         config.setJdbcUrl("jdbc:mysql://localhost:3306/____?serverTimezone=UTC");
         config.setUsername("____");
         config.setPassword("____");
         config.addDataSourceProperty("cachePrepStmts", "true");
         config.addDataSourceProperty("prepStmtCacheSize", "250");
         config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

//         //HikariDataSource ==> ConnectionPool
//         HikariDataSource ds = new HikariDataSource(config);
//         Connection conn = ds.getConnection();
//         Assertions.assertNotNull(conn);
//         System.out.println(conn);
//         conn.close();
         //HikariDataSource ==> ConnectionPool
         //try-with-resource 구문을 사용하여 conn과 ds 자동으로 닫혀서 안전하게 테스트를 종료
        try(HikariDataSource ds = new HikariDataSource(config);
         Connection conn = ds.getConnection()) {
         Assertions.assertNotNull(conn);
         System.out.println(conn);
            }

}
}
// @Test 를 적용하는 메소드는 public , 파라미터나 리턴타입 없이 작성한다.
//assertEquals()의 의미는 "같다고 확신하다"
