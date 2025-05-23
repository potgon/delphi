package dev.potgon.Noesis.auth.infrastructure;

import dev.potgon.Noesis.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
