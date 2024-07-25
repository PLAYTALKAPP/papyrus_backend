package com.example.papyrus.service;

import com.example.papyrus.dto.TodoDTO;
import com.example.papyrus.dto.TodoListDTO;
import com.example.papyrus.mapper.TodoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoMapper todoMapper;

    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public List<TodoDTO> getTodoListByUserId(String user_id) {
        return  todoMapper.getTodoListByUserId(user_id);
    }

    @Override
    public List<TodoListDTO> getTodoListByTodoId(long todo_id) {
        return todoMapper.getTodoListByTodoId(todo_id);
    }

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {
        return todoMapper.addTodo(todoDTO);
    }


    @Override
    public List<TodoListDTO> addTodoListByTodo_id(TodoListDTO todoListDTO) {
        return todoMapper.addTodoListByTodo_id(todoListDTO);
    }

}
