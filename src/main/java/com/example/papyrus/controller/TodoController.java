package com.example.papyrus.controller;

import com.example.papyrus.dto.TodoDTO;
import com.example.papyrus.dto.TodoListDTO;
import com.example.papyrus.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@Controller
public class TodoController {

   @Autowired
   private TodoService todoService;

    @GetMapping("/todo/user/{user_id}")
    public ResponseEntity<List<TodoDTO>> getTodoByUserId(@PathVariable("user_id") String user_id) {
        List<TodoDTO> todos = todoService.getTodoListByUserId(user_id);
        return ResponseEntity.ok(todos);
    }
    @GetMapping("/todo/{todo_id}")
    public ResponseEntity<List<TodoListDTO>> getTodoByTodoId(@PathVariable("todo_id") long todo_id) {
        List<TodoListDTO> todolist = todoService.getTodoListByTodoId(todo_id);
//        System.out.println(todolist);
        return ResponseEntity.ok(todolist);
    }

    //투두리스트 대제목 추가
    //대제목 추가시 리스트로 같이 등록할수있으면 좋을것 같음.
    //유저정보등록도필요함
    @PutMapping("/todo/addTodo")
    public ResponseEntity<TodoDTO>  addTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO result = todoService.addTodo(todoDTO);
        return ResponseEntity.ok(result);
    }


    //투두리스트 부분추가
    @PutMapping("/todo/addTodoList")
    public ResponseEntity<List<TodoListDTO>>  addTodoList(@RequestBody TodoListDTO todoListDTO) {

        //TODO 정보를 가져와서 TODOLIST에 저장
        List<TodoListDTO> result = todoService.addTodoListByTodo_id(todoListDTO);
        return ResponseEntity.ok(result);

    }


}
