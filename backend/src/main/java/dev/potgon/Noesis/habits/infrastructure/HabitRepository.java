package dev.potgon.Noesis.habits.infrastructure;

import dev.potgon.Noesis.habits.domain.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
}
