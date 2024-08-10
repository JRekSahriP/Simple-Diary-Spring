package com.SimpleDiaryApp.exceptions;

public class InvalidNoteTextException extends RuntimeException {
	
	public InvalidNoteTextException() {super("Invalid Text");}
	public InvalidNoteTextException(String message) {super(message);}

}
