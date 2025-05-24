package dev.potgon.Noesis.auth.application;

import dev.potgon.Noesis.auth.domain.User;

public interface AuthService {
    User getCurrentUser();
}
