package com.hrnchshn.finance.exeptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(RuntimeException e, WebRequest request){
		String body = "Entity not found";
		return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(IOException.class)
	protected ResponseEntity<Object> handleIOException(RuntimeException e, WebRequest request){
		String body = "Failed to connect. IO Exception";
		return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.BAD_GATEWAY, request);
	}
}
