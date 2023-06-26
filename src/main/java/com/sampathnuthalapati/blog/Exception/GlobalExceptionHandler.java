package com.sampathnuthalapati.blog.Exception;

import com.sampathnuthalapati.blog.Payload.APIRespnse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIRespnse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        APIRespnse apiRespnse = new APIRespnse(message, false);
        return new ResponseEntity<APIRespnse>(apiRespnse, HttpStatus.NOT_FOUND);
    }
}
