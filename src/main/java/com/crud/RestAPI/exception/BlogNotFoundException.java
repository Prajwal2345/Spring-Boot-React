package com.crud.RestAPI.exception;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String id){
        super("Could not found blog");
    }
}
