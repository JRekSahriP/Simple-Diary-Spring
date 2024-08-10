package com.SimpleDiaryApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SimpleDiaryApp.entitys.Note;
import com.SimpleDiaryApp.services.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@PostMapping
	public Note newNote(@RequestBody Note note) {
		return noteService.newNote(note);
	}
	@DeleteMapping("/{id}")
	public void deleteNote(@PathVariable Long id) {
		noteService.deleteNote(id);
	}
	@PutMapping("/{id}")
	public Note findAndUpdateNote(@PathVariable Long id, @RequestBody Note newNote) {
		return noteService.findAndUpdateNote(id, newNote);
	}
	@PatchMapping("/{id}")
	public Note updateNote(@PathVariable Long id, @RequestBody Note newNote) {
		return noteService.updateNote(id, newNote);
	}
	
	@GetMapping
	public List<Note> getAllNotes(){
		return noteService.getAllNotes();
	}
	@GetMapping("/{id}")
	public Note getNoteById(@PathVariable Long id) {
		return noteService.getNoteById(id);
	}
	@GetMapping("/byMonth/{month}")
	public List<Note> getNotesByMonth(@PathVariable int month) {
		return noteService.getNotesByMonth(month);
	}
	@GetMapping("/byYear/{year}")
	public List<Note> getNotesByYear(@PathVariable int year) {
		return noteService.getNotesByYear(year);
	}
}
