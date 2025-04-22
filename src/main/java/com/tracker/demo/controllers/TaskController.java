package com.tracker.demo.controllers;


import com.tracker.demo.DTO.ApiResponse;
import com.tracker.demo.entity.Task;
import com.tracker.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PreAuthorize("hasRole('1')")
    @PostMapping("/create/task")
    public Object createTask(@RequestBody Task task) {
        try {
            Task savedTask = taskService.saveTask(task);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponse.created(savedTask));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('1')")
    @GetMapping("/tasks/{username}")
    public Object findTaskByUsername(@PathVariable String username) {
        try{
            List<Task> tasks = taskService.findByUsername(username);
            if (tasks.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "NOT_FOUND", "No task found for " + username));
            }
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(tasks));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "INTERNAL_SERVER_ERROR", e.getMessage()));
        }
    }

    @PreAuthorize("hasRole('1')")
    @DeleteMapping("/delete/task/{serialNumber}")
    public Object deleteTask(@PathVariable Long serialNumber) {
        try {
            Optional<Task> task = taskService.findBySerialNumber(BigDecimal.valueOf(serialNumber));
            if (task.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "NOT_FOUND", "No task found for " + serialNumber));
            }
            taskService.deleteTask(task.get());
            return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(task.get()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
