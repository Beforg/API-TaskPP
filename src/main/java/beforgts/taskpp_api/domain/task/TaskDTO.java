package beforgts.taskpp_api.domain.task;

public record TaskDTO(String id, String title, String description, String date, String listId, boolean deactivated, boolean completed, String listName) {
    public TaskDTO(Task task) {
        this(task.getId().toString(), task.getTitle(), task.getDescription(), task.getDate(),
                task.getTaskList() != null ? task.getTaskList().getId().toString() : null, task.isDeactivated(), task.isCompleted(), task.getTaskList() != null ? task.getTaskList().getName() : "");
    }
}