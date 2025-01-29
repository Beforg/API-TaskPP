package beforgts.taskpp_api.repository;

import beforgts.taskpp_api.domain.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Query("SELECT t FROM Task t WHERE t.date = :date AND t.deactivated = false ORDER BY t.title ASC")
    Page<Task> findByDate(String date, Pageable pageable);
    @Query("SELECT t FROM Task t WHERE t.date < :date AND t.deactivated = false AND t.completed = false ORDER BY t.title ASC")
    Page<Task> findByDateBefore(String date, Pageable pageable);
    @Query("SELECT t FROM Task t WHERE t.date > :date AND t.deactivated = false ORDER BY t.title ASC")
    Page<Task> findByDateAfter(String date, Pageable pageable);
    @Query("SELECT COUNT(t) FROM Task t WHERE t.date = :date AND t.deactivated = false")
    int countByDate(String date);
    @Query("SELECT COUNT(t) FROM Task t WHERE t.date < :date AND t.deactivated = false AND t.completed = false")
    int countByDateBefore(String date);
    @Query("SELECT COUNT(t) FROM Task t WHERE t.date > :date AND t.deactivated = false")
    int countByDateAfter(String date);
    int countByDeactivated(boolean b);
    @Query("SELECT t FROM Task t WHERE t.deactivated = true ORDER BY t.title ASC")
    Page<Task> findByDeactivated(Pageable pageable);
    @Query("SELECT t FROM Task t WHERE t.taskList.id = :uuid AND t.deactivated = false ORDER BY t.title ASC")
    Page<Task> findByTaskListId(UUID uuid, PageRequest of);
    @Query("SELECT t FROM Task t WHERE t.taskList.id = :uuid ORDER BY t.title ASC ")
    List<Task> findAllByTaskListId(UUID uuid);
}
