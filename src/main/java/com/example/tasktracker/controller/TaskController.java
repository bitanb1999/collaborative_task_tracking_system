package com.example.tasktracker.controller;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getTasksByUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam String query) {
        return ResponseEntity.ok(taskService.searchTasks(query));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Task>> filterTasks(@RequestParam String status) {
        return ResponseEntity.ok(taskService.filterTasks(status));
    }

    @PostMapping("/{taskId}/comments")
    public ResponseEntity<Void> addComment(@PathVariable Long taskId, @RequestBody String comment) {
        taskService.addComment(taskId, comment);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{taskId}/attachments")
    public ResponseEntity<Void> addAttachment(@PathVariable Long taskId, @RequestBody byte[] attachment) {
        taskService.addAttachment(taskId, attachment);
        return ResponseEntity.ok().build();
    }
}