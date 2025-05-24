package dev.potgon.Noesis.journal.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
@RequiredArgsConstructor
public class EntryController {

    private final EntryService service;

    @PostMapping
    public ResponseEntity<?> createEntry(
            @RequestBody EntryDTO dto,
            @AuthenticationPrincipal UserDetails user
    ) {
        service.createEntry(dto, user.getUsername());
        return ResponseEntity.ok().build();
    }
}
