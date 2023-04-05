package com.example.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dataAccess.TodoRepository;
import com.example.todo.models.TodoItem;
import com.example.todo.pojos.requests.CreateTodoItemRequest;
import com.example.todo.pojos.responses.CommandResponse;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository; 
    
    @PostMapping
    public ResponseEntity createTodoItem(@RequestBody CreateTodoItemRequest request){

        var todo = new TodoItem(request.getTitle(), request.getDescription()); 
        todoRepository.save(todo);
        return new ResponseEntity(new CommandResponse<Integer>(todo.getId()), HttpStatusCode.valueOf(200)); 
    }
}
