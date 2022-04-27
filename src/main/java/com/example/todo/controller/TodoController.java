package com.example.todo.controller;

import com.example.todo.entity.TodoEntity;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity creatTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo,userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Wrong Motherfucker");
        }
    }

    @PutMapping
    public ResponseEntity creatTodo(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(userId));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Wrong Motherfucker");
        }
    }
}
