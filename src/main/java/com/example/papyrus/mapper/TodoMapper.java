package com.example.papyrus.mapper;

import com.example.papyrus.dto.TodoDTO;
import com.example.papyrus.dto.TodoListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<TodoDTO> getTodoListByUserId(String user_id);

    List<TodoListDTO> getTodoListByTodoId(long todo_id);

    TodoDTO addTodo(TodoDTO todoDTO);

    List<TodoListDTO> addTodoListByTodo_id(TodoListDTO todoListDTO);
}
