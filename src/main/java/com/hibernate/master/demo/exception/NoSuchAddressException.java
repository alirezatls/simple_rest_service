package com.hibernate.master.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchAddressException extends RuntimeException {
    public NoSuchAddressException() {
    }

    public NoSuchAddressException(String message) {
        super(message);
    }
}
