package com.example;

import java.sql.SQLException;

import com.example.View.TodoCLI;
import com.example.dao.TodoDao;
import com.example.dao.TodoDaoJdbc;
import com.example.database.DatabaseConnection;
import com.example.service.TodoService;
import com.example.service.TodoServicelmpl;

public class Main {
    public static void main(String[] args) throws SQLException {
            try {
            TodoDao todoDao = new TodoDaoJdbc();
            TodoService todoService = new TodoServicelmpl(todoDao);
            TodoCLI cli = new TodoCLI(todoService);
            cli.start();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
    }
