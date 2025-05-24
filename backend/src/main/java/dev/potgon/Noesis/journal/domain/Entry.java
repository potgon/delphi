package dev.potgon.Noesis.journal.domain;

import dev.potgon.Noesis.auth.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime createdAt;

    @Lob
    private String content;

    @ElementCollection
    private List<EmotionIntensity> emotions;

    @Column(name = "dopamine_level")
    private Integer dopamineLevel;

    @ElementCollection
    private Set<String> tags;

    @Column(name = "ai_summary")
    @Lob
    private String aiSummary;

    @Column(name = "ai_emotional_analysis")
    @Lob
    private String aiEmotionalAnalysis;

    @Column(name = "follow_up_suggestion")
    @Lob
    private String followUpSuggestion;

    @Column(name = "voice_transcription")
    private String voiceTranscription;
}
