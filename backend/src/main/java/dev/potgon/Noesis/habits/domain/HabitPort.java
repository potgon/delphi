package dev.potgon.Noesis.habits.domain;

import java.time.LocalDate;
import java.util.List;

public interface HabitPort {
    Habit findHabitByIdOrThrowEx(Long id);

    void save(Habit entity);

    void saveHabitRecord(HabitRecord entity);

    List<HabitRecord> findRecordsByUserAndDateRange(Long userId, LocalDate from, LocalDate to);
}
