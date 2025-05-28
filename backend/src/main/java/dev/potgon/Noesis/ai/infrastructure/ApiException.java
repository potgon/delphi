package dev.potgon.Noesis.ai.infrastructure;

import org.springframework.http.HttpStatusCode;

public class ApiException extends RuntimeException {
    public ApiException(String message, HttpStatusCode statusCode) {
        super("[%d] %s".formatted(statusCode.value(), message));
    }
}
