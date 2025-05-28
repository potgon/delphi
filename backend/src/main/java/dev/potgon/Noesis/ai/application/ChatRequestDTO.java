package dev.potgon.Noesis.ai.application;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChatRequestDTO {
    private String model;
    private List<MessageDTO> messages;
}
