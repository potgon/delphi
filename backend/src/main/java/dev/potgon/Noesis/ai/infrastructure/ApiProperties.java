package dev.potgon.Noesis.ai.infrastructure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "perplexity.api")
public class ApiProperties {
    private String url;
    private String key;
    private String model;
}
