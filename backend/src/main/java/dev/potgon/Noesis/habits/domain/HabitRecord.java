package dev.potgon.Noesis.habits.domain;

import dev.potgon.Noesis.auth.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class HabitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Habit habit;

    private LocalDate date;

    private boolean completed;
}
