package dev.potgon.Noesis.auth.application;

import dev.potgon.Noesis.habits.domain.HabitRecord;
import dev.potgon.Noesis.journal.domain.Entry;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private Enum<UserType> userType;
    private String pin;
    private String biometricHash;
    private List<Entry> entries = new ArrayList<>();
    private List<HabitRecord> habitRecords = new ArrayList<>();
}
