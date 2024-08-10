package com.SimpleDiaryApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SimpleDiaryApp.entitys.Note;
import com.SimpleDiaryApp.exceptions.InvalidNoteTextException;
import com.SimpleDiaryApp.exceptions.NoteNotFoundException;
import com.SimpleDiaryApp.repositorys.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	/*CRUD*/
	//POST
	public Note newNote(Note note) {
		String text = note.getText().trim();
		if (text==null||text.isEmpty()) {throw new InvalidNoteTextException("Note text cannot be null or empty");}
		return noteRepository.save(note);
	}
	
	//DELETE
	public void deleteNote(Long id) {
		noteRepository.deleteById(id);
	}
	
	//PUT
	public Note findAndUpdateNote(Long id, Note newNote) {
		return noteRepository.findById(id).map(note -> {
			note.setText(newNote.getText());
			return noteRepository.save(note);
		}).orElseGet(() ->{
			return noteRepository.save(newNote);
		});
	}
	
	//PATCH
	public Note updateNote(Long id, Note newNote) {
		Note note = noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundException("Note not found. ID:"+id));
		note.setText(newNote.getText());
		return noteRepository.save(note);
	}
	
	
	/*READ*/
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	
	public Note getNoteById(Long id) {
		return noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundException("Note not found. ID:"+id));
	}
	
	public List<Note> getNotesByMonth(int month){
		return noteRepository.findNotesByMonth(month);
	}
	
	public List<Note> getNotesByYear(int year){
		return noteRepository.findNotesByYear(year);
	}
	
}
