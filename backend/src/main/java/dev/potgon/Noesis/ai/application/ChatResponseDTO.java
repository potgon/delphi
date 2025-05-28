package dev.potgon.Noesis.ai.application;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChatResponseDTO {
    private List<MessageDTO> messages;
}
