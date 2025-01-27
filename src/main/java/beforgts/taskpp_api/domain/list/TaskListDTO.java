package beforgts.taskpp_api.domain.list;

public record TaskListDTO(String id, int tasks, String name, String category) {
    public TaskListDTO(TaskList taskList) {
            this(taskList.getId().toString(), taskList.getTaskListSize(), taskList.getName(), taskList.getCategory());
    }
}
