package beforgts.taskpp_api.domain.list;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskListDTO(@NotBlank String name, @NotBlank String category) {
}
