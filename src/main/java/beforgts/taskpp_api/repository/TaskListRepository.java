package beforgts.taskpp_api.repository;

import beforgts.taskpp_api.domain.list.TaskList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskListRepository extends JpaRepository<TaskList, UUID> {
    Page<TaskList> findAll(Pageable pageable);
}
