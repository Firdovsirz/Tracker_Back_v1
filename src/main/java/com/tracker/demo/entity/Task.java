package com.tracker.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "\"tasks\"")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "serial_number", nullable=false)
    private BigDecimal serialNumber;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_desc", nullable = false)
    private String taskDesc;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "deadline", nullable = false)
    private Date deadline;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "status")
    private Integer status;

    @Column(name = "fulfillment")
    private Integer fulfillment;

    @Column(name = "is_private")
    private Integer isPrivate;

   // constructor


    public Task(Long id,
                BigDecimal serialNumber,
                String username,
                String taskTitle,
                String taskDesc,
                Date createdAt,
                Date deadline,
                Date deletedAt,
                Integer status,
                Integer fulfillment,
                Integer isPrivate

    ) {
        this.id = id;
        this.username = username;
        this.serialNumber = serialNumber;
        this.taskTitle = taskTitle;
        this.taskDesc = taskDesc;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.deletedAt = deletedAt;
        this.status = status;
        this.fulfillment = fulfillment;
        this.isPrivate = isPrivate;
    }

    public Task() {}

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(BigDecimal serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(Integer fullfilment) {
        this.fulfillment = fullfilment;
    }

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }

    // To String

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", serialNumber=" + serialNumber +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", createdAt=" + createdAt +
                ", deadline=" + deadline +
                ", deletedAt=" + deletedAt +
                ", status=" + status +
                ", fulfilment=" + fulfillment +
                ", isPrivate=" + isPrivate +
                '}';
    }

    @PrePersist
    public void onPrePersist() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }
        if (this.serialNumber == null) {
            this.serialNumber = generateRandomSerialNumber();
        }
        if (this.status == null) {
            this.status = 0; // or any default status
        }
        if (this.fulfillment == null) {
            this.fulfillment = 0; // or any default value
        }
    }


    private BigDecimal generateRandomSerialNumber() {
        long randomNumber = System.currentTimeMillis() + (long) (Math.random() * 1000);
        return new BigDecimal(randomNumber);
    }
}
