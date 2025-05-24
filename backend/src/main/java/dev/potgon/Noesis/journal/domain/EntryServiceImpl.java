package dev.potgon.Noesis.journal.domain;

import dev.potgon.Noesis.auth.domain.AuthPort;
import dev.potgon.Noesis.auth.domain.User;
import dev.potgon.Noesis.journal.application.EntryDTO;
import dev.potgon.Noesis.journal.application.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService {

    private final EntryPort port;
    private final AuthPort authPort;

    @Override
    public void createEntry(EntryDTO dto, String username) {
        Optional<User> user = authPort.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        Entry entry = Entry.builder()
                .user(user.get())
                .createdAt(LocalDateTime.parse(dto.getCreatedAt()))
                .content(dto.getContent())
                .emotions(dto.getEmotions().stream()
                        .map(emotionsDto -> EmotionIntensity.builder()
                                .emotion(emotionsDto.getEmotion())
                                .intensity(emotionsDto.getIntensity())
                                .build())
                        .toList())
                .dopamineLevel(dto.getDopamineLevel())
                .tags(dto.getTags())
                .aiSummary(dto.getAiSummary())
                .aiEmotionalAnalysis(dto.getAiEmotionalAnalysis())
                .followUpSuggestion(dto.getFollowUpSuggestion())
                .voiceTranscription(dto.getVoiceTranscription())
                .build();
        port.save(entry);
    }
}
