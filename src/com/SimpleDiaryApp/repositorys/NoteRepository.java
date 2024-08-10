package com.SimpleDiaryApp.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SimpleDiaryApp.entitys.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long>{
	
	@Query("SELECT n FROM Note n WHERE FUNCTION('MONTH', n.createdAt) = :month")
	List<Note> findNotesByMonth(@Param("month") int month);
	
	@Query("SELECT n FROM Note n WHERE FUNCTION('YEAR', n.createdAt) = :year")
	List<Note> findNotesByYear(@Param("year") int year);
}
