package beforgts.taskpp_api.domain.task;

import jakarta.validation.constraints.NotBlank;

public record UpdateTaskDTO(@NotBlank  String title, String description,@NotBlank String date, String idList) {
}
