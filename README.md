# Simple-Diary-Spring 
Simple-Diary-Spring is a simple CRUD built with Spring Boot.

## Technologies Used
- Spring Boot
- Spring Data JPA

## Endpoints
- POST -> /note - Creates a new note.
- DELETE -> /note/{id} - Deletes a note by ID.
- PUT -> /note/{id} - Updates an existing note or creates a new note if it does not exist.
- PATCH -> /note/{id} - Updates only the text of an existing note.
- GET -> /note - Retrieves all notes.
- GET -> /note/{id} - Retrieves a note by ID.
- GET -> /note/byMonth/{month} - Retrieves notes by month.
- GET -> /note/byYear/{year} - Retrieves notes by year.
