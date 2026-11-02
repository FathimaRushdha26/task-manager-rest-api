
package taskmanager.service;
import taskmanager.exception.TaskNotFoundException;
import taskmanager.entity.Task;
import taskmanager.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by ID

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(
                                "Task not found with ID: " + id
                        ));
    }


    // Update task
    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(existingTask);
    }

    // Delete task
    public void deleteTask(Long id) {

        Task existingTask = getTaskById(id);

        taskRepository.delete(existingTask);
    }

    // Search tasks by title
    public List<Task> searchTasks(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    // Filter tasks by status
    public List<Task> filterTasksByStatus(String status) {
        return taskRepository.findByStatusIgnoreCase(status);
    }

    // Update task status
    public Task updateTaskStatus(Long id, String status) {

        Task task = getTaskById(id);

        if (!status.matches("PENDING|IN_PROGRESS|COMPLETED")) {
            throw new IllegalArgumentException(
                    "Invalid status. Use PENDING, IN_PROGRESS or COMPLETED"
            );
        }

        task.setStatus(status);

        return taskRepository.save(task);
    }

}

