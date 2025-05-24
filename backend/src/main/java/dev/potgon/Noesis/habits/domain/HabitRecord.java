package dev.potgon.Noesis.habits.domain;

import dev.potgon.Noesis.auth.domain.User;
import dev.potgon.Noesis.journal.domain.EmotionIntensity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class HabitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    private LocalDate date;

    private boolean completed;

    @ElementCollection
    private List<EmotionIntensity> emotions;

    @Column(name = "dopamine_level")
    private Integer dopamineLevel;
}
