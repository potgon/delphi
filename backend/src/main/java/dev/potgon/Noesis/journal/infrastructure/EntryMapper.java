package dev.potgon.Noesis.journal.infrastructure;

import dev.potgon.Noesis.journal.application.EmotionIntensityDTO;
import dev.potgon.Noesis.journal.application.EntryDTO;
import dev.potgon.Noesis.journal.domain.EmotionIntensity;
import dev.potgon.Noesis.journal.domain.Entry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntryMapper {

    Entry toEntity(EntryDTO dto);
    EntryDTO toDTO(Entry entity);

    EmotionIntensity toEmotionEntity(EmotionIntensityDTO dto);
    EmotionIntensityDTO toEmotionDTO(EmotionIntensity entity);
}
