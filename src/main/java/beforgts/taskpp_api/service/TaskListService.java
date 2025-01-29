package beforgts.taskpp_api.service;

import beforgts.taskpp_api.domain.list.CreateTaskListDTO;
import beforgts.taskpp_api.domain.list.TaskList;
import beforgts.taskpp_api.domain.list.TaskListDTO;
import beforgts.taskpp_api.domain.task.Task;
import beforgts.taskpp_api.repository.TaskListRepository;
import beforgts.taskpp_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository repository;
    @Autowired
    private TaskRepository taskRepository;

    public void create(CreateTaskListDTO dto) {
        TaskList taskList = new TaskList(dto);
        try {
            this.repository.save(taskList);
        } catch (Exception e) {
            throw new RuntimeException("Error creating list.");
        }
    }

    public List<TaskListDTO> getAll() {
        return this.repository.findAll().stream().map(TaskListDTO::new).toList();
    }

    public Page<TaskListDTO> get(int page, int size) {
        return this.repository.findAll(PageRequest.of(page, size)).map(TaskListDTO::new);
    }

    public void update(String id, CreateTaskListDTO dto) {
        TaskList taskList = this.repository.findById(UUID.fromString(id)).orElseThrow();
        taskList.update(dto);
        this.repository.save(taskList);
    }

    public void delete(String id) {
        List<Task> tasks = this.taskRepository.findAllByTaskListId(UUID.fromString(id));
        for (Task task : tasks) {
            task.setTaskList(null);
            this.taskRepository.save(task);
        }
        this.repository.deleteById(UUID.fromString(id));
    }
}
