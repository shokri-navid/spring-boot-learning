package com.example.todo.pojos.responses;

import java.util.Date;

public class TodoItemDto {
    private Integer id; 
    
    private String title;
    
    private String description;
   
    private Boolean isDone; 

    private Date createdAt; 

    private Date doneAt;
   
    public Date getDoneAt() {
        return doneAt;
    }
    public void setDoneAt(Date doneAt) {
        this.doneAt = doneAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    } 

}
