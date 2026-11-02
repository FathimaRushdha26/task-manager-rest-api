
package taskmanager.controller;

import taskmanager.entity.Task;
import taskmanager.service.TaskService;

import org.springframework.http.HttpStatus;
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

    // Create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(
            @Valid @RequestBody Task task) {

        Task createdTask = taskService.createTask(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTask);
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {

        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(
            @PathVariable Long id) {

        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // Update a task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task task) {

        return ResponseEntity.ok(
                taskService.updateTask(id, task)
        );
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }

    // Search tasks by title
    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(
            @RequestParam String title) {

        return ResponseEntity.ok(
                taskService.searchTasks(title)
        );
    }

    // Filter tasks by status
    @GetMapping("/filter")
    public ResponseEntity<List<Task>> filterTasks(
            @RequestParam String status) {

        return ResponseEntity.ok(
                taskService.filterTasksByStatus(status)
        );
    }

    // Update task status
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                taskService.updateTaskStatus(id, status)
        );
    }
}
