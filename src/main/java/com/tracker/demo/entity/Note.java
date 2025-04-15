package com.tracker.demo.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "\"notes\"")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serial_number", nullable = false)
    private BigDecimal serialNumber;

    @Column(name = "note_title", nullable = true)
    private String noteTitle;

    @Column(name = "note_desc", nullable = false)
    private String noteDesc;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "deleted_at", nullable = true)
    private Date deletedAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    @Column(name = "username", nullable = false)
    private String username;

    // constructor

    public Note(Long id, BigDecimal serialNumber, String noteTitle, String noteDesc, Date createdAt, Date deletedAt, Date updatedAt, String username) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.updatedAt = updatedAt;
        this.username = username;
    }


    public Note() {}

    // Getter/Setter for Id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter/Setter for serial number

    public BigDecimal getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(BigDecimal serialNumber) {
        this.serialNumber = serialNumber;
    }

    // Getter/Setter for note title

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    // Getter/Setter for note description

    public String getNoteDesc() {
        return noteDesc;
    }

    public void setNoteDesc(String noteDesc) {
        this.noteDesc = noteDesc;
    }

    // Getter/Setter for created at

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    // Getter/Setter for deleted at

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    // Getter/Setter for updated at

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Getter/Setter for Username

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // To String()

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteDesc='" + noteDesc + '\'' +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", updatedAt=" + updatedAt +
                ", username='" + username + '\'' +
                '}';
    }

    // auto date generate for the created at

    @PrePersist
    public void onPrePersist() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }

        // Generate a unique random serial number
        if (this.serialNumber == null) {
            this.serialNumber = generateRandomSerialNumber();
        }
    }

    // Utility method to generate a random BigDecimal serial number
    private BigDecimal generateRandomSerialNumber() {
        long randomNumber = System.currentTimeMillis() + (long) (Math.random() * 1000);
        return new BigDecimal(randomNumber);
    }

}
