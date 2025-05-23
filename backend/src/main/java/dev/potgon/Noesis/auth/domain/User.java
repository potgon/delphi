package dev.potgon.Noesis.auth.domain;

import dev.potgon.Noesis.auth.application.UserType;
import dev.potgon.Noesis.journal.domain.Entry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum<UserType> userType;

    private String pin;

    private String biometricHash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Entry> entries = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HabitRecord> habitRecords = new ArrayList<>();
}
