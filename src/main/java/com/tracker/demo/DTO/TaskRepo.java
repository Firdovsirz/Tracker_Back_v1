package com.tracker.demo.DTO;
import com.tracker.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findAllByUsername(String username);
    Optional<Task> findBySerialNumber(BigDecimal serialNumber);
}
