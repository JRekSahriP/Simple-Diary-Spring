package com.SimpleDiaryApp.entitys;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


@Entity
public class Note {
	public Note() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = this.createdAt;
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	public Long getId() {return id;}
	
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	
	public LocalDateTime getCreatedAt() {return createdAt;}
	public LocalDateTime getUpdatedAt() {return updatedAt;}
	
	public int getCreatedDay() {return createdAt.getDayOfMonth();}
	public int getUpdatedDay() {return updatedAt.getDayOfMonth();}
	public int getCreatedMonth() {return createdAt.getMonthValue();}
	public int getUpdatedMonth() {return updatedAt.getMonthValue();}
	public int getCreatedYear() {return createdAt.getYear();}
	public int getUpdatedYear() {return updatedAt.getYear();}
	
}
