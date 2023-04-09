package com.example.todo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo.dataAccess.TodoRepository;
import com.example.todo.mapper.AutoTodoItemMapper;
import com.example.todo.models.TodoItem;
import com.example.todo.pojos.requests.CreateTodoItemRequest;
import com.example.todo.pojos.responses.GeneralResponse;
import com.example.todo.pojos.responses.TodoItemDto;

import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository; 
    
    // @Autowired
    // private JMapperAPI  mapperApi; 
    
    public TodoController() {
        super();

    }

    @PostMapping(value = "/")
    public ResponseEntity createTodoItem(@RequestBody CreateTodoItemRequest request){

        var todo = new TodoItem(request.getTitle(), request.getDescription()); 
        todoRepository.save(todo);
        return new ResponseEntity(new GeneralResponse<Integer>(todo.getId()), HttpStatusCode.valueOf(200)); 
    }

    @GetMapping(value="/{id}")
    public @ResponseBody ResponseEntity getTodoItam(@PathVariable Integer id) {
        Optional<TodoItem> result = todoRepository.findById(id);
        
        var res = AutoTodoItemMapper.MAPPER.toDto(result.get());
        
        return new ResponseEntity(new GeneralResponse(res),HttpStatusCode.valueOf(200));
    }
    
}
