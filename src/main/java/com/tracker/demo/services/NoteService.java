package com.tracker.demo.services;

import com.tracker.demo.entity.Note;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> findByUsername(String username);
    Optional<Note> findBySerialNumber(BigDecimal serialNumber);
    Note saveNote(Note note);
    long deleteNote(BigDecimal serialNumber);
}
