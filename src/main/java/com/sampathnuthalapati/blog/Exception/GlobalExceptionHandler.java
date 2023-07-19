package com.sampathnuthalapati.blog.Exception;

import com.sampathnuthalapati.blog.Payload.APIRespnse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIRespnse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        APIRespnse apiRespnse = new APIRespnse(message, false);
        return new ResponseEntity<APIRespnse>(apiRespnse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        Map<String, String> response = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            response.put(fieldName, message);

        });

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<APIRespnse> handleApiException(ApiException ex) {
        String message = ex.getMessage();
        APIRespnse apiRespnse = new APIRespnse(message, true);
        return new ResponseEntity<APIRespnse>(apiRespnse, HttpStatus.BAD_REQUEST);
    }
}
