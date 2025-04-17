package com.tracker.demo.DTO;

import com.tracker.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUsername(String username);
    Optional<Note> findBySerialNumber(BigDecimal serialNumber);

    long deleteBySerialNumber(BigDecimal serialNumber);
}