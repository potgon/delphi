package dev.potgon.Noesis.habits.infrastructure;

import dev.potgon.Noesis.habits.domain.HabitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface HabitRecordRepository extends JpaRepository<HabitRecord, Long> {
    List<HabitRecord> findByUserIdAndDateBetween(Long userId, LocalDate from, LocalDate to);
}
