package com.example.todo.dataAccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.todo.models.TodoItem;

public interface TodoRepository extends CrudRepository<TodoItem, Integer>
,PagingAndSortingRepository<TodoItem, Integer>{
    
}
