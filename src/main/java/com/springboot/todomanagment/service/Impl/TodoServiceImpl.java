package com.springboot.todomanagment.service.Impl;

import com.springboot.todomanagment.dto.TodoDto;
import com.springboot.todomanagment.exception.ResourceNotFoundException;
import com.springboot.todomanagment.model.Todo;
import com.springboot.todomanagment.repository.TodoRepository;
import com.springboot.todomanagment.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // Convert TodoDto into Todo JPA Entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // Todo JPA Entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved Todo JPA Entity into TodoDto object
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo","id", id));
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todo, long id) {
        Todo existingTodo = todoRepository.findById(todo.getId())
                            .orElseThrow(()-> new ResourceNotFoundException("Todo not found with id:" + id));
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setCompleted(todo.isCompleted());

        Todo updatedTodo = todoRepository.save(existingTodo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(long id) {
    Todo existingTodo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo", "id", id));
    todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto incompleteTodo(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));

        todo.setCompleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}
