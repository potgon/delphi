package dev.potgon.Noesis.ai.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {
    private String content;
    private ApiRole role;
}
