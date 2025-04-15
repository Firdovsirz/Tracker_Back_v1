package com.tracker.demo.services;

import com.tracker.demo.DTO.NoteRepository;
import com.tracker.demo.entity.Note;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> findByUsername(String username) {
        return noteRepository.findAllByUsername(username);
    }

    @Override
    public Optional<Note> findBySerialNumber(BigDecimal serialNumber) {
        return noteRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }
}
