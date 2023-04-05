package com.example.todo.pojos.responses;

import java.util.ArrayList;

public class CommandResponse<T> {
    
    public CommandResponse(ArrayList<ErrorTemplate> errorTemplates) {
        isSucceed = false;
        this.errorTemplates = errorTemplates;
    }
    
    public CommandResponse(T data) {
        this.data = data;
        this.isSucceed = true;
    }  

    private T data ; 
   
    private Boolean isSucceed; 
    
    private ArrayList<ErrorTemplate> errorTemplates = new ArrayList<ErrorTemplate>();

   
    public ArrayList<ErrorTemplate> getErrorTemplates() {
        return errorTemplates;
    }

    public Boolean getIsSucceed() {
        return isSucceed;
    }

    public T getData() {
        return data;
    }
    
}
