package dev.potgon.Noesis.journal.application;

public interface EntryService {
    void createEntry(EntryDTO dto, String username);
}
