package beforgts.taskpp_api.domain;

import org.springframework.http.HttpStatus;

public record ResponseDTO(String message, HttpStatus status) {
}
