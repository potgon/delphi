package dev.potgon.Noesis.auth.domain;

import java.util.Optional;

public interface AuthPort {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    User findByUsernameOrThrowEx(String username);
}
