package com.niraj.sbt.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.niraj.sbt.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEnityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException ex,
			WebRequest request) {

		ErrorMessage errMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errMessage);
	}

	@ExceptionHandler(InvalidRequestParameterException.class)
	public ResponseEntity<ErrorMessage> invalidRequestParameterException(InvalidRequestParameterException ex,
			WebRequest request) {

		ErrorMessage errMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errMessage);
	}

	
}
