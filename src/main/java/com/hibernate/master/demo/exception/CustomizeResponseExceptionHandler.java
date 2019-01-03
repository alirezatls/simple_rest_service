package com.hibernate.master.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

/*
this exception handler shoulde apply to all controller
 */
@ControllerAdvice
@RestController
public class CustomizeResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        ExceptionFormatResponse formatResponse =
                new ExceptionFormatResponse(new Date(),ex.getMessage(),request.getDescription(false));

        //ResponseEntity(T body of response, Status)
        return new ResponseEntity(formatResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NoSuchStudentException.class})
    public final ResponseEntity<Object> handleNoSuchStudentException(NoSuchStudentException ex, WebRequest request) {
        ExceptionFormatResponse formatResponse =
                new ExceptionFormatResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(formatResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchAddressException.class)
    public final ResponseEntity<Object> handleNoSuchAddressException(NoSuchAddressException ex, WebRequest request) {
        ExceptionFormatResponse formatResponse =
                new ExceptionFormatResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(formatResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchCourseException.class)
    public final ResponseEntity<Object> handleNoSuchCourseException(NoSuchCourseException ex, WebRequest request) {
        ExceptionFormatResponse formatResponse =
                new ExceptionFormatResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(formatResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyListException.class)
    public final ResponseEntity<Object> handleEmptyListException(EmptyListException ex, WebRequest request) {
        ExceptionFormatResponse formatResponse =
                new ExceptionFormatResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(formatResponse,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NoSuchManagerException.class)
    public final ResponseEntity<Object> handleNoSuchManagerException(NoSuchManagerException ex, WebRequest request) {
        ExceptionFormatResponse formatResponse =
                new ExceptionFormatResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(formatResponse,HttpStatus.NOT_FOUND);
    }



}
