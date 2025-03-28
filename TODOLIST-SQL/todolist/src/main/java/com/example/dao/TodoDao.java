package com.example.dao;

import java.util.List;
import com.example.model.Todo;


//Menerapkan ocp prinsiple
//Interface ini memungkinkan untuk estensi tanpa modifikasi
public interface TodoDao {
void create(Todo todo) throws Exception;
void update(Todo todo) throws Exception;
void delete(int id) throws Exception;

Todo findByid(int id) throws Exception;

List<Todo> findAll () throws Exception;

}
