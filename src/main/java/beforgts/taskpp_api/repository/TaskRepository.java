package beforgts.taskpp_api.repository;

import beforgts.taskpp_api.domain.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Query("SELECT t FROM Task t WHERE t.date = :date")
    Page<Task> findByDate(String date, Pageable pageable);
    @Query("SELECT t FROM Task t WHERE t.date < :date")
    Page<Task> findByDateBefore(String date, Pageable pageable);
    @Query("SELECT t FROM Task t WHERE t.date > :date")
    Page<Task> findByDateAfter(String date, Pageable pageable);
    @Query("SELECT COUNT(t) FROM Task t WHERE t.date = :date")
    int countByDate(String date);
    @Query("SELECT COUNT(t) FROM Task t WHERE t.date < :date")
    int countByDateBefore(String date);
    @Query("SELECT COUNT(t) FROM Task t WHERE t.date > :date")
    int countByDateAfter(String date);
    int countByDeactivated(boolean b);
}
