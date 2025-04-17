package com.tracker.demo.controllers;

import com.tracker.demo.DTO.ApiResponse;
import com.tracker.demo.entity.Note;
import com.tracker.demo.services.NoteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PreAuthorize("hasRole('1')")
    @PostMapping("/create/note")
    public Object createNote(@RequestBody Note note) {
        logger.info("Received note creation request: {}", note);
        try {
            Note savedNote = noteService.saveNote(note);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponse.created(savedNote));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(
                            500, "INTERNAL_SERVER_ERROR", e.getMessage()
                    ));
        }
    }

    @PreAuthorize("hasRole('1')")
    @GetMapping("/note/user/{username}")
    public ResponseEntity<?> getNotesByUsername(@PathVariable String username) {
        try {
            List<Note> notes = noteService.findByUsername(username);
            if (notes == null || notes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "NOT_FOUND", "No notes found for username: " + username));
            }
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(notes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "INTERNAL_SERVER_ERROR", e.getMessage()));
        }
    }

    // Get a note by serial number
    @GetMapping("note/serial/{serialNumber}")
    public Optional<Note> getNoteBySerialNumber(@PathVariable BigDecimal serialNumber) {
        return noteService.findBySerialNumber(serialNumber);
    }

    @PreAuthorize("hasRole('1')")
    @PatchMapping("/note/update/{serialNumber}")
    public ResponseEntity<?> updateNote(@PathVariable BigDecimal serialNumber, @RequestBody Note updatedNote) {
        try {
            Optional<Note> optionalNote = noteService.findBySerialNumber(serialNumber);
            if (optionalNote.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "NOT_FOUND", "Note not found with ID: " + serialNumber));
            }

            Note existingNote = optionalNote.get();

            if (updatedNote.getNoteTitle() != null) {
                existingNote.setNoteTitle(updatedNote.getNoteTitle());
            }
            if (updatedNote.getNoteDesc() != null) {
                existingNote.setNoteDesc(updatedNote.getNoteDesc());
            }
            if (updatedNote.getSerialNumber() != null) {
                existingNote.setSerialNumber(updatedNote.getSerialNumber());
            }

            Note savedNote = noteService.saveNote(existingNote);
            return ResponseEntity.ok(ApiResponse.success(savedNote));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "INTERNAL_SERVER_ERROR", e.getMessage()));
        }
    }

    @PreAuthorize("hasRole('1')")
    @DeleteMapping("/note/delete/{serialNumber}")
    public ResponseEntity<?> deleteNote(@PathVariable BigDecimal serialNumber) {
        try {
            Optional<Note> optionalNote = noteService.findBySerialNumber(serialNumber);
            System.out.println(optionalNote.isPresent());
            if (optionalNote.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "NOT_FOUND", "Note not found with ID: " + serialNumber));
            }
            System.out.println("Deleting note: " + serialNumber);
            Note existingNote = optionalNote.get();
            System.out.println(existingNote.getNoteTitle());
            noteService.deleteNote(serialNumber);
            return ResponseEntity.ok(ApiResponse.success(existingNote));
        } catch (Exception e) {
            logger.error("Error while deleting note", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "INTERNAL_SERVER_ERROR", e.getMessage()));
        }
    }
}