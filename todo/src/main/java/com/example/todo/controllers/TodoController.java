package com.example.todo.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo.dataAccess.TodoRepository;
import com.example.todo.mapper.AutoTodoItemMapper;
import com.example.todo.models.ItemStatus;
import com.example.todo.models.TodoItem;
import com.example.todo.pojos.requests.CreateTodoItemRequest;
import com.example.todo.pojos.requests.UpdateTodoItemRequest;
import com.example.todo.pojos.responses.GeneralResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository; 
    
    // @Autowired
    // private JMapperAPI  mapperApi; 
    
    public TodoController() {
        super();

    }

    @Operation(summary = "Create a todo list item")
    @PostMapping(value = "/")
    public ResponseEntity createTodoItem(@RequestBody CreateTodoItemRequest request){

        var todo = new TodoItem(request.getTitle(), request.getDescription()); 
        todoRepository.save(todo);
        return new ResponseEntity(new GeneralResponse<Integer>(todo.getId()), HttpStatusCode.valueOf(200)); 
    }

    @Operation(summary = "Retrieve a Todo Item using its ID ")
    @GetMapping(value="/{id}")
    public @ResponseBody ResponseEntity getTodoItam(@PathVariable Integer id) {
        
        Optional<TodoItem> result = todoRepository.findById(id);
        
        var res = AutoTodoItemMapper.MAPPER.toDto(result.get());
        
        return new ResponseEntity(new GeneralResponse(res),HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "Update Todo Item (only title and description)")
    @PutMapping(value="/{id}")
    public @ResponseBody ResponseEntity updateTodoItem(
        @PathVariable Integer id, 
        @RequestBody UpdateTodoItemRequest request){
        
            var todo = todoRepository.findById(id); 
            if (todo.isEmpty())
            {
                return new ResponseEntity(new GeneralResponse(""),HttpStatusCode.valueOf(404));
            }
            var main = todo.get();
            main.setDescription(request.getDescription());
            main.setTitle(request.getTitle());
            todoRepository.save(main);
            return new ResponseEntity(new GeneralResponse(""),HttpStatusCode.valueOf(200));
        }

    @Operation(summary = "Perform a query over Todo list ")
    @GetMapping(value = "/")
    public @ResponseBody ResponseEntity getAllTodoItems(
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "0") Integer pageNo, 
        @RequestParam(defaultValue = "createdAt") String sorting){

            Pageable paging = PageRequest.of(pageNo, pageSize, Direction.ASC, sorting);
            Page result = todoRepository.findAll(paging);
            List<TodoItem> list  = result.getContent();
            var res = list.stream().map(x-> AutoTodoItemMapper.MAPPER.toDto(x)).toList(); 
            return new ResponseEntity(new GeneralResponse(res), HttpStatusCode.valueOf(200));
        }
    @Operation(summary = "change done status of todo item")
    @PutMapping(value = "/{id}/status/{status}")
    public @ResponseBody ResponseEntity changeTodoStatus(@PathVariable int id, @PathVariable ItemStatus status){
        var todo = todoRepository.findById(id); 
            if (todo.isEmpty())
            {
                return new ResponseEntity(new GeneralResponse(""),HttpStatusCode.valueOf(404));
            }
            
            TodoItem item = todo.get();
            item.setStatus(status);
            todoRepository.save(item);
            return new ResponseEntity(new GeneralResponse(""),HttpStatusCode.valueOf(200));
    }
}
