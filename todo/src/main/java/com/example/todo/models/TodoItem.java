package com.example.todo.models;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 

    private String title; 

    private String description; 
     
    private Boolean isDone; 

    private Date createdAt; 

    private Date doneAt;

    protected TodoItem() {
        super();
    }
    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
        isDone = false; 
        createdAt =  java.util.Date
        .from(LocalDateTime.now().atZone(ZoneId.systemDefault())
        .toInstant());
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
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(Date doneAt) {
        this.doneAt = doneAt;
    }
     
}
