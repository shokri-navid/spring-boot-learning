package com.example.todo.pojos.requests;

public class CreateTodoItemRequest {
    private String title;
    private String description; 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    } 
}
