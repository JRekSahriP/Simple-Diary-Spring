package com.SimpleDiaryApp.exceptions;

public class NoteNotFoundException extends RuntimeException {
	
	public NoteNotFoundException() {super("Note Not Found");}
	public NoteNotFoundException(String message) {super(message);}

}
