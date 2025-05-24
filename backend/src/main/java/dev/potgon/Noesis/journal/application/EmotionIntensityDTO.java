package dev.potgon.Noesis.journal.application;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmotionIntensityDTO {
    private String emotion;
    private Integer intensity;
}
