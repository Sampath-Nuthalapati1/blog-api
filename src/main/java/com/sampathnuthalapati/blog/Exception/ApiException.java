package com.sampathnuthalapati.blog.Exception;

public class ApiException extends RuntimeException{
    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }
}
