package com.example.todo.pojos.responses;

public class ErrorTemplate {
    public ErrorTemplate(String message, String code) {
        this.message = message;
        this.code = code;
    }
    
    private String message;
    
    private String code;
    
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
