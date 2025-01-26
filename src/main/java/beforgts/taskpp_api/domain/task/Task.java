package beforgts.taskpp_api.domain.task;

import beforgts.taskpp_api.domain.list.TaskList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String  title;
    private String description;
    private String date;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private TaskList taskList;
    @Setter
    private boolean deactivated;

    public Task(CreateTaskDTO dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.date = dto.date();
    }

    public Task () {

    }

    public void updateTask(UpdateTaskDTO dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.date = dto.date();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public boolean isDeactivated() {
        return deactivated;
    }
}
