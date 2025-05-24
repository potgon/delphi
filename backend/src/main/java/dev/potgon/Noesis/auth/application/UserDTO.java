package dev.potgon.Noesis.auth.application;

import dev.potgon.Noesis.habits.application.HabitRecordDTO;
import dev.potgon.Noesis.journal.application.EntryDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String email;
    private String passwordHash;
    private Enum<UserType> userType;
    private String pin;
    private String biometricHash;
    private List<EntryDTO> entries = new ArrayList<>();
    private List<HabitRecordDTO> habitRecords = new ArrayList<>();
}
