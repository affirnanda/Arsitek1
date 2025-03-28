package com.example.service;

import java.util.List;
import com.example.model.Todo;

//Service Interface - Menerapkan Ocp 
public interface TodoService {
  
        void addTodo(String title, String description) throws Exception;
        void updateTodo(Todo todo) throws Exception;
        void deleteTodo(int id) throws Exception;
        Todo getTodoByid(int id) throws Exception;
        
        List<Todo> getallTodos () throws Exception;
        
        void markAscompleted(int id) throws Exception;
        

}
