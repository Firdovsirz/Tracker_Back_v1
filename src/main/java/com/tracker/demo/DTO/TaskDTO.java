package com.tracker.demo.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class TaskDTO {
    private Long id;
    private BigDecimal serialNumber;
    private String taskTitle;
    private String taskDesc;
    private Date createdAt;
    private Date deadline;
    private Date deletedAt;
    private Integer status;
    private Integer fullfilment;
    private Integer isPrivate;

    public TaskDTO(
            Long id,
            BigDecimal serialNumber,
            String taskTitle,
            String taskDesc,
            Date createdAt,
            Date deadline,
            Date deletedAt,
            Integer status,
            Integer fullfilment
    ) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.taskTitle = taskTitle;
        this.taskDesc = taskDesc;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.deletedAt = deletedAt;
        this.status = status;
        this.fullfilment = fullfilment;
        this.isPrivate = isPrivate;
    }

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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFulfillment() {
        return fullfilment;
    }

    public void setFullfillment(Integer fullfilment) {
        this.fullfilment = fullfilment;
    }

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }
}
