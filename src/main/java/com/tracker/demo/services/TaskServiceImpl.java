package com.tracker.demo.services;

import com.tracker.demo.DTO.TaskRepo;
import com.tracker.demo.entity.Task;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public List<Task> findByUsername(String username) {
        return taskRepo.findAllByUsername(username);
    }

    @Override
    public Optional<Task> findBySerialNumber(BigDecimal serialNumber) {
        return taskRepo.findBySerialNumber(serialNumber);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task deleteTask(Task task) {
        taskRepo.delete(task);
        return task;
    }
}
