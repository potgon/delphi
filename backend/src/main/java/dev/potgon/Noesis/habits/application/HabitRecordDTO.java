package dev.potgon.Noesis.habits.application;

import dev.potgon.Noesis.journal.application.EmotionIntensityDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitRecordDTO {
    private Long habitId;
    private String date;
    private boolean completed;
    private List<EmotionIntensityDTO> emotions;
    private Integer dopamineLevel;
}
