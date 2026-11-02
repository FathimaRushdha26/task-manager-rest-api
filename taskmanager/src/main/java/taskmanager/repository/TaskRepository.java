
package taskmanager.repository;

import taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Search tasks by title
    List<Task> findByTitleContainingIgnoreCase(String title);

    // Filter tasks by status
    List<Task> findByStatusIgnoreCase(String status);
}

