package com.example.papyrus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListDTO {
    private long todolist_id;
    private long todo_id;
    private String description;
    private boolean todo_checking;

    private String todo_cate;
}
