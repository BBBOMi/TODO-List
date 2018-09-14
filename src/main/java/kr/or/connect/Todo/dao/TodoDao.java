package kr.or.connect.Todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import kr.or.connect.Todo.dto.TodoDto;

public class TodoDao {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/pjt_todo";
  private static final String DB_USER = "";
  private static final String DB_PASSWD = "";

  public int addTodo(TodoDto todo) {
    int insertCount = 0;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
    
    String sql = "INSERT INTO todo(title, name, sequence) VALUES (?, ?, ?)";
    
    try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, todo.getTitle());
      ps.setString(2, todo.getName());
      ps.setInt(3, todo.getSequence());
      
      insertCount = ps.executeUpdate();
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return insertCount;   
  }
  
  public List<TodoDto> getTodos() {
    List<TodoDto> list = new ArrayList<>();
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
    
    String sql = "SELECT * FROM todo ORDER BY regdate";
    
    try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        PreparedStatement ps = conn.prepareStatement(sql)) {
      
      try(ResultSet rs = ps.executeQuery()) {
        while(rs.next()) {
          Long id = rs.getLong(1);
          String title = rs.getString(2);
          String name = rs.getString(3);
          int sequence = rs.getInt(4);
          String type = rs.getString(5);
          String regdate = rs.getString(6);
         
          Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(regdate);
          String newDate = new SimpleDateFormat("yyyy.MM.dd").format(date);

          TodoDto todo = new TodoDto(id, title, name, sequence, type, newDate);
          list.add(todo);
        }
      } catch(Exception e) {
        e.printStackTrace();
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public int updateTodo(long id, String type) {
    int updateCount = 0;

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String sql = "UPDATE todo SET type = ? WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        PreparedStatement ps = conn.prepareStatement(sql)) {
      String updatedType = "";
      if ("TODO".equals(type)) {
        updatedType = "DOING";
      } else if ("DOING".equals(type)) {
        updatedType = "DONE";
      }
      ps.setString(1, updatedType);
      ps.setLong(2, id);
      
      updateCount = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updateCount;
  }
}
