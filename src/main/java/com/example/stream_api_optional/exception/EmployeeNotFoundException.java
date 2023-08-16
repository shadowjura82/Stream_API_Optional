package com.example.stream_api_optional.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Employee not found");
    }
}
