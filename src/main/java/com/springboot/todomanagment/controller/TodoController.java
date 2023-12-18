package com.springboot.todomanagment.controller;

import com.springboot.todomanagment.dto.TodoDto;
import com.springboot.todomanagment.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    // Add TODO REST API
    // http://localhost:8080/api/todos
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Get Todo REST API
    // http://localhost:8080/api/todos/{id}
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") long id){
        TodoDto todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }

    // Get All Todo's REST API
    // http://localhost:8080/api/todos
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    // Update Todo REST API
    // http://localhost:8080/api/todos/{id}
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodo);
    }
}
