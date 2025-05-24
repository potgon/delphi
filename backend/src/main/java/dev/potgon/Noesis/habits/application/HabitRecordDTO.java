package dev.potgon.Noesis.habits.application;

import dev.potgon.Noesis.auth.domain.User;
import dev.potgon.Noesis.habits.domain.Habit;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitRecordDTO {
    private Long id;
    private User user;
    private Habit habit;
    private LocalDate date;
    private boolean completed;
}
