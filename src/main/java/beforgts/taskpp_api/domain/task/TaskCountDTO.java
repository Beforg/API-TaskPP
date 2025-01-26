package beforgts.taskpp_api.domain.task;

public record TaskCountDTO(int todayTask, int tomorrowTask, int nextTasks, int lateTasks, int deactivatedTasks) {
}
