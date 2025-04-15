package com.tracker.demo.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class NoteDTO {
    private Long id;
    private BigDecimal serialNumber;
    private String noteTitle;
    private String noteDesc;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String username;

    public NoteDTO() {}

    public NoteDTO(Long id, BigDecimal serialNumber, String noteTitle, String noteDesc,
                   Date createdAt, Date updatedAt, Date deletedAt, String username) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.username = username;
    }

    // Getters and Setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(BigDecimal serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDesc() {
        return noteDesc;
    }

    public void setNoteDesc(String noteDesc) {
        this.noteDesc = noteDesc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}