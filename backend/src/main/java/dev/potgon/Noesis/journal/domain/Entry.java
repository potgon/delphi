package dev.potgon.Noesis.journal.domain;

import dev.potgon.Noesis.auth.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime createdAt;

    @Lob
    private String content;

    @ElementCollection
    private Map<String, Integer> emotions; // e.g., {"joy": 3, "sadness": 1}

    private Integer dopamineLevel;

    @ElementCollection
    private Set<String> tags;

    @Lob
    private String aiSummary;

    @Lob
    private String aiEmotionalAnalysis;

    @Lob
    private String followUpSuggestion;

    private String voiceTranscription;
}
