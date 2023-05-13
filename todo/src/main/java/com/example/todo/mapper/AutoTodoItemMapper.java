package com.example.todo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.todo.models.TodoItem;
import com.example.todo.pojos.responses.TodoItemDto;

@Mapper
public interface AutoTodoItemMapper {
    AutoTodoItemMapper MAPPER = Mappers.getMapper(AutoTodoItemMapper.class); 

    TodoItemDto toDto(TodoItem item);
    TodoItem toEntity(TodoItemDto dto);

}
