package com.tracker.demo.services;
import com.tracker.demo.entity.Task;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    List<Task> findByUsername(String username);
    Optional<Task> findBySerialNumber(BigDecimal serialNumber);
    Task saveTask(Task task);
    Task deleteTask(Task task);
}