package com.hibernate.master.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchManagerException extends RuntimeException{
    public NoSuchManagerException() {
    }

    public NoSuchManagerException(String message) {
        super(message);
    }
}
