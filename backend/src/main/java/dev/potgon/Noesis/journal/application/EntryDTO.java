package dev.potgon.Noesis.journal.application;

import dev.potgon.Noesis.auth.domain.User;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntryDTO {
    private Long id;
    private User user;
    private LocalDateTime createdAt;
    private String content;
    private Map<String, Integer> emotions; // e.g., {"joy": 3, "sadness": 1}
    private Integer dopamineLevel;
    private Set<String> tags;
    private String aiSummary;
    private String aiEmotionalAnalysis;
    private String followUpSuggestion;
    private String voiceTranscription;
}
