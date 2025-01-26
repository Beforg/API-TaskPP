package beforgts.taskpp_api.service;

import beforgts.taskpp_api.domain.task.*;
import beforgts.taskpp_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public void create(CreateTaskDTO dto) {
        try {
            Task task = new Task(dto);
            repository.save(task);
        } catch (Exception e) {
            throw new RuntimeException("Error creating task: " + e.getMessage());
        }

    }

    public void update(String id, UpdateTaskDTO dto) {
        Optional<Task> task = repository.findById(UUID.fromString(id));
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found.");
        }
        Task updatedTask = task.get();
        updatedTask.updateTask(dto);
        updatedTask.setCompleted(!updatedTask.isCompleted());
        repository.save(updatedTask);

    }

    public void deactivate(String id) {
        Optional<Task> task = repository.findById(UUID.fromString(id));
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found.");
        }
        Task updatedTask = task.get();
        updatedTask.setDeactivated(!updatedTask.isDeactivated());
        repository.save(updatedTask);
    }

    public void updateStatus(String id) {
        Optional<Task> task = repository.findById(UUID.fromString(id));
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found.");
        }
        Task updatedTask = task.get();
        updatedTask.setCompleted(!updatedTask.isCompleted());
        repository.save(updatedTask);
    }

    public void delete(String id) {
        Optional<Task> task = repository.findById(UUID.fromString(id));
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found.");
        }
        repository.delete(task.get());
    }

    public Page<TaskDTO> list(String date, int page, int size) {
        return repository.findByDate(date, PageRequest.of(page, size)).map(TaskDTO::new);
    }
    public Page<TaskDTO> listLate(String date, int page, int size) {
        return repository.findByDateBefore(date, PageRequest.of(page, size)).map(TaskDTO::new);
    }

    public TaskCountDTO countTask() {
        int today = repository.countByDate(LocalDate.now().toString());
        int late = repository.countByDateBefore(LocalDate.now().toString());
        int tomorrow = repository.countByDate(LocalDate.now().plusDays(1).toString());
        int next = repository.countByDateAfter(LocalDate.now().plusDays(1).toString());
        int deactivated = repository.countByDeactivated(true);
        return new TaskCountDTO(today, tomorrow,next, late, deactivated);

    }
}
