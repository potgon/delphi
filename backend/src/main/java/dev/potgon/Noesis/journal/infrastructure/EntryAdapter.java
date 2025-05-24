package dev.potgon.Noesis.journal.infrastructure;

import dev.potgon.Noesis.journal.domain.Entry;
import dev.potgon.Noesis.journal.domain.EntryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntryAdapter implements EntryPort {

    private final EntryRepository repo;

    @Override
    public void save(Entry entity) {
        repo.save(entity);
    }
}
