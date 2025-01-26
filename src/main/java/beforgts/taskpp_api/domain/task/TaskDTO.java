package beforgts.taskpp_api.domain.task;

public record TaskDTO(String id, String title, String description, String date, String listId) {
    public TaskDTO(Task task) {
        this(task.getId().toString(), task.getTitle(), task.getDescription(), task.getDate(), task.getTaskList().getId().toString());
    }
}
