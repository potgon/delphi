package dev.potgon.Noesis.ai.infrastructure;

import dev.potgon.Noesis.ai.application.ApiRole;
import dev.potgon.Noesis.ai.application.ChatRequestDTO;
import dev.potgon.Noesis.ai.application.ChatResponseDTO;
import dev.potgon.Noesis.ai.application.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApiClient {

    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    public ResponseEntity<ChatResponseDTO> makeApiRequest(String userMessage) {
        ChatRequestDTO request = ChatRequestDTO.builder()
                .model(apiProperties.getModel())
                .messages(List.of(
                        MessageDTO.builder()
                                .role(ApiRole.USER)
                                .content(userMessage)
                                .build()
                ))
                .build();

        HttpHeaders headers = buildHeaders();
        HttpEntity<ChatRequestDTO> entity = new HttpEntity<>(request, headers);

        return restTemplate.exchange(
                apiProperties.getUrl(),
                HttpMethod.POST,
                entity,
                ChatResponseDTO.class
        );
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiProperties.getKey());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
