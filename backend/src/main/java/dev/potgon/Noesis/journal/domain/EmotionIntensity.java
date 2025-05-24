package dev.potgon.Noesis.journal.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmotionIntensity {
    private String emotion;
    private Integer intensity;
}
