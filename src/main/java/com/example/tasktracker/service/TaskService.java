package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final AiService aiService;

    public TaskService(TaskRepository taskRepository, AiService aiService) {
        this.taskRepository = taskRepository;
        this.aiService = aiService;
    }

    public Task createTask(Task task) {
        // Generate description using AI if empty
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            task.setDescription(aiService.generateTaskDescription(task.getTitle()));
        }
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // Assuming user ID is fetched from username (simplified)
        return taskRepository.findByAssigneeId(1L); // Replace with actual user ID logic
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTask(Long id, Task task) {
        Task existing = getTask(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setDueDate(task.getDueDate());
        existing.setStatus(task.getStatus());
        return taskRepository.save(existing);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> searchTasks(String query) {
        return taskRepository.findByTitleContainingOrDescriptionContaining(query, query);
    }

    public List<Task> filterTasks(String status) {
        return taskRepository.findByStatus(status);
    }

    public void addComment(Long taskId, String comment) {
        // Simplified: Implement comment creation logic
    }

    public void addAttachment(Long taskId, byte[] attachment) {
        // Simplified: Implement attachment creation logic
    }
}