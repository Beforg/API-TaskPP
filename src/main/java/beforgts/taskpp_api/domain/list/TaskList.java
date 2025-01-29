package beforgts.taskpp_api.domain.list;

import beforgts.taskpp_api.domain.task.Task;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "lists")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String category;
    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;
    private boolean deactivated;

    public TaskList() {

    }

    public TaskList(CreateTaskListDTO dto) {
        this.name = dto.name();
        this.category = dto.category();
    }

    public int getTaskListSize () {
        return (int) tasks.stream().filter(task -> !task.isDeactivated()).count();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public void update(CreateTaskListDTO dto) {
        this.name = dto.name();
        this.category = dto.category();
    }
}
