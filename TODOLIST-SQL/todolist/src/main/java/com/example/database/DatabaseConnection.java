package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/todolist-sol";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

   public static Connection getConnection() throws SQLException{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }catch(ClassNotFoundException e) {
        throw new SQLException("My sql jdbc tidak ditemukan", e);
    }
    return connection;
   }


   public static void closeConnection() throws SQLException {
    if (connection != null && !connection.isClosed()) {
        connection.close();
    }
   } 
}
