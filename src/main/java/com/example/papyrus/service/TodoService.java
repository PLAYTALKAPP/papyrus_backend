package com.example.papyrus.service;

import com.example.papyrus.dto.TodoDTO;
import com.example.papyrus.dto.TodoListDTO;

import java.util.List;

public interface TodoService {
    //XXX. 유저별 TODO 출력
    List<TodoDTO> getTodoListByUserId(String user_id);

    //XXX. TODO 내 TODOLIST 출력
    List<TodoListDTO> getTodoListByTodoId(long todo_id);

    //XXX. TODO 등
    TodoDTO addTodo(TodoDTO todoDTO);

    //XXX. TODOList 등록
    List<TodoListDTO> addTodoListByTodo_id(TodoListDTO todoListDTO);
}
