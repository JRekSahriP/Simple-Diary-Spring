package com.SimpleDiaryApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoteNotFoundException.class)
	public ResponseEntity<String> NoteNotFoundHandler(NoteNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidNoteTextException.class)
	public ResponseEntity<String> InvalidNoteTextHandler(InvalidNoteTextException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> NullPointerHandler(NullPointerException exception){
		return new ResponseEntity<String>("Internal Error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
