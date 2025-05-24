package dev.potgon.Noesis.habits.application;

import java.util.List;

public interface HabitService {
    void createHabit(HabitDTO dto, String username);
    void recordHabit(HabitRecordDTO dto, String username);
    List<HabitRecordDTO> getHabitRecords(String from, String to, String username);
}
