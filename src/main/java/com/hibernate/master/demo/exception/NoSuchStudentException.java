package com.hibernate.master.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchStudentException extends RuntimeException {
    public NoSuchStudentException() {
    }

    public NoSuchStudentException(String message) {
        super(message);
    }
}
