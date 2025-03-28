package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Array;

import com.example.database.DatabaseConnection;
import com.example.model.Todo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TodoDaoJdbc implements TodoDao {
    
    @Override
   // CREATE
     public void create(Todo todo) throws Exception {
      String sql = "INSERT INTO todos (title, description, completed) VALUES (?, ?, ?)";

      try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

         stmt.setString(1, todo.getTitle());
         stmt.setString(2, todo.getDescription());
         stmt.setBoolean(3, todo.isCompleted());

         int affectedRows = stmt.executeUpdate();

         if (affectedRows == 0) {
            throw new Exception("Gagal membuat todo, tidak ada baris yang terpengaruh.");
         }

         try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
               todo.setId(generatedKeys.getInt(1));
            } else {
               throw new Exception("Gagal membuat todo, tidak ada ID yang diperoleh.");
            }
         }
      }
   }
    @Override
    public void update(Todo todo) throws Exception {
        String sql = "UPDATE todos SET title = ?, description = ?, completed = ? WHERE id = ?";
  
        try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
  
           stmt.setString(1, todo.getTitle());
           stmt.setString(2, todo.getDescription());
           stmt.setBoolean(3, todo.isCompleted());
           stmt.setInt(4, todo.getId());
  
           int affectedRows = stmt.executeUpdate();
  
           if (affectedRows == 0) {
              throw new Exception("Gagal mengupdate todo, tidak ada baris yang terpengaruh.");
           }
        }
     } {
        
    }
    @Override
    public void delete (int id) throws Exception {
        String sql = "DELETE FROM todos WHERE id = ?";

      try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setInt(1, id);

         int affectedRows = stmt.executeUpdate();

         if (affectedRows == 0) {
            throw new Exception("Gagal menghapus todo, tidak ada baris yang terpengaruh.");
         }
      }
    }
    
    @Override
    public Todo findByid (int id) throws Exception {
        String sql = "SELECT * FROM todos WHERE id = ?";

      try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

         stmt.setInt(1, id);

         try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
               return extraceTodoFromResultset(rs);
            } else {
               return null;
            }
         }
      }
    }

    public List <Todo> findAll () throws Exception {
         String sql = "SELECT * FROM todos";
      List<Todo> todos = new ArrayList<>();

      try (Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

         while (rs.next()) {
            todos.add(extraceTodoFromResultset(rs));
         }
      }

      return todos;
    }

    private Todo extraceTodoFromResultset(ResultSet set) throws Exception {
       Todo todo = new Todo();
       todo.setId(set.getInt("id"));
       todo.setTitle(set.getString("title"));
       todo.setDescription(set.getString("description"));
       todo.setCompleted(set.getBoolean("completed"));
       
       return todo;
    }
}
