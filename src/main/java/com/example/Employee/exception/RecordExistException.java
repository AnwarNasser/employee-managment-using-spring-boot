package com.example.Employee.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.CONFLICT)
public class RecordExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public RecordExistException(String message)
    {
        super(message);
    }
    public RecordExistException(String message,Throwable cause) {
        super(message, cause);
    }
}
