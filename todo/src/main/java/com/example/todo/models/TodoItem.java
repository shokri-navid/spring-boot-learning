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
     
    private Date createdAt; 

    private Date doneAt;

    private ItemStatus status; 

    public ItemStatus getStatus() {
        return status;
    }
    public void setStatus(ItemStatus status) {
        this.status = status;
        if (status == ItemStatus.done){
            doneAt = getNow();
        }
    }
    protected TodoItem() {
        super();
    }
    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
        createdAt =  getNow();
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
        return status == ItemStatus.done;
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

    private Date getNow(){
        return java.util.Date
        .from(LocalDateTime.now().atZone(ZoneId.systemDefault())
        .toInstant());
    }
}
