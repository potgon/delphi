package dev.potgon.Noesis.journal.application;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntryDTO {
    private String createdAt;
    private String content;
    private List<EmotionIntensityDTO> emotions;
    private Integer dopamineLevel;
    private Set<String> tags;
    private String aiSummary;
    private String aiEmotionalAnalysis;
    private String followUpSuggestion;
    private String voiceTranscription;
}
