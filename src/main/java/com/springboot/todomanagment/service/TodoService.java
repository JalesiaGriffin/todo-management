package com.springboot.todomanagment.service;

import com.springboot.todomanagment.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, long id);

    void deleteTodo(long id);

    TodoDto completeTodo(long id);

    TodoDto incompleteTodo(long id);
}
