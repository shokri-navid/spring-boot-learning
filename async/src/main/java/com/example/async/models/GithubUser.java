package com.example.async.models;
 
public class GithubUser {
    
    private String name; 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String id; 
    public String getId() {
        return id;
    }
    public void setUsername(String id) {
        this.id = id;
    }
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", id=" + id + "]";
    }
}
