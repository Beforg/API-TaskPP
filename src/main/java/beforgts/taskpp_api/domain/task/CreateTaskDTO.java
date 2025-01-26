package beforgts.taskpp_api.domain.task;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskDTO(@NotBlank String title, String description, @NotBlank String date, String listId) {
}
