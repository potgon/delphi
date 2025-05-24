package dev.potgon.Noesis.auth.infrastructure;

import dev.potgon.Noesis.auth.domain.AuthPort;
import dev.potgon.Noesis.auth.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthAdapter implements AuthPort {

    private final UserRepository repo;

    @Override
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public User findByUsernameOrThrowEx(String username) throws UsernameNotFoundException{
        Optional<User> user = repo.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        return user.get();
    }
}
