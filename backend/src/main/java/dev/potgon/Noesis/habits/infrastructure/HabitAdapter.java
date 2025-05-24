package dev.potgon.Noesis.habits.infrastructure;

import dev.potgon.Noesis.habits.domain.Habit;
import dev.potgon.Noesis.habits.domain.HabitPort;
import dev.potgon.Noesis.habits.domain.HabitRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HabitAdapter implements HabitPort {

    private final HabitRepository repo;
    private final HabitRecordRepository recordRepo;

    @Override
    public Habit findHabitByIdOrThrowEx(Long id) {
        Optional<Habit> habit = repo.findById(id);
        if (habit.isEmpty()) {
            throw new UsernameNotFoundException("Habito no encontrado: " + id);
        }
        return habit.get();
    }

    @Override
    public void save(Habit entity) {
        repo.save(entity);
    }

    @Override
    public void saveHabitRecord(HabitRecord entity) {
        recordRepo.save(entity);
    }

    @Override
    public List<HabitRecord> findRecordsByUserAndDateRange(Long userId, LocalDate from, LocalDate to) {
        return recordRepo.findByUserIdAndDateBetween(userId, from, to);
    }
}
