package com.springboot.todomanagment.repository;

import com.springboot.todomanagment.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
