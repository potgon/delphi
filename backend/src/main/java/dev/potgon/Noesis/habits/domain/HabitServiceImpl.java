package dev.potgon.Noesis.habits.domain;

import dev.potgon.Noesis.auth.domain.AuthPort;
import dev.potgon.Noesis.auth.domain.User;
import dev.potgon.Noesis.habits.application.HabitDTO;
import dev.potgon.Noesis.habits.application.HabitRecordDTO;
import dev.potgon.Noesis.habits.application.HabitService;
import dev.potgon.Noesis.journal.application.EmotionIntensityDTO;
import dev.potgon.Noesis.journal.domain.EmotionIntensity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitPort port;
    private final AuthPort authPort;

    @Override
    public void createHabit(HabitDTO dto, String username) {
        User user = authPort.findByUsernameOrThrowEx(username);
        Habit habit = Habit.builder()
                .user(user)
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        port.save(habit);
    }

    @Override
    public void recordHabit(HabitRecordDTO dto, String username) {
        User user = authPort.findByUsernameOrThrowEx(username);
        HabitRecord record = HabitRecord.builder()
                .habit(port.findHabitByIdOrThrowEx(dto.getHabitId()))
                .user(user)
                .date(LocalDate.parse(dto.getDate()))
                .completed(dto.isCompleted())
                .emotions(dto.getEmotions().stream()
                        .map(emotionsDto -> EmotionIntensity.builder()
                                .emotion(emotionsDto.getEmotion())
                                .intensity(emotionsDto.getIntensity())
                                .build())
                        .toList())
                .dopamineLevel(dto.getDopamineLevel())
                .build();
        port.saveHabitRecord(record);
    }

    @Override
    public List<HabitRecordDTO> getHabitRecords(String from, String to, String username) {
        Long userId = authPort.findByUsernameOrThrowEx(username).getId();
        List<HabitRecord> records = port.findRecordsByUserAndDateRange(userId, LocalDate.parse(from), LocalDate.parse(to));
        return records.stream().map(record -> HabitRecordDTO.builder()
                        .habitId(record.getHabit().getId())
                        .date(record.getDate().toString())
                        .completed(record.isCompleted())
                        .emotions(record.getEmotions().stream()
                                .map(e -> EmotionIntensityDTO.builder()
                                        .emotion(e.getEmotion())
                                        .intensity(e.getIntensity())
                                        .build())
                                .toList())
                        .dopamineLevel(record.getDopamineLevel())
                        .build())
                .toList();
    }
}
