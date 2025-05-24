package dev.potgon.Noesis.habits.application;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitDTO {
    private Long id;
    private String name;
    private String description;
}
