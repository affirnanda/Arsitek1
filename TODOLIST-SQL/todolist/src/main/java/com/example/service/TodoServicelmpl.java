package com.example.service;
import java.util.List;
import com.example.model.Todo;
import com.example.dao.TodoDao;


public class TodoServicelmpl implements TodoService {
    private final TodoDao todoDao;
    
    public TodoServicelmpl(TodoDao todoDao) {
        this.todoDao = todoDao ;
    }

    @Override
    public void addTodo(String title, String description) throws Exception {
        Todo todo = new Todo(title, description);
        todoDao.create(todo);
    }
    @Override
    public void updateTodo(Todo todo) throws Exception {
        todoDao.update(todo);
    }
    @Override
    public void deleteTodo(int id)  throws Exception {
        todoDao.delete(id);
    }
    @Override
    public Todo getTodoByid(int id) throws Exception {
        return todoDao.findByid(id);
    }
    @Override
    public List <Todo> getallTodos( ) throws Exception {
        return todoDao.findAll();
    }
    @Override
    public void markAscompleted(int id) throws Exception {
        Todo todo = todoDao.findByid(id);

        if (todo != null) {
            todo.setCompleted(true);
            todoDao.update(todo);
        }else{
            throw new Exception("todo dengan id" + id + "tidak ditemukan");
        }
    }
}
