package dev.potgon.Noesis.habits.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habit")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService service;

    @PostMapping
    public ResponseEntity<?> createHabit(@RequestBody HabitDTO habitDTO, @AuthenticationPrincipal UserDetails user) {
        service.createHabit(habitDTO, user.getUsername());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/record")
    public ResponseEntity<?> recordHabit(@RequestBody HabitRecordDTO recordDTO, @AuthenticationPrincipal UserDetails user) {
        service.recordHabit(recordDTO, user.getUsername());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/records")
    public ResponseEntity<List<HabitRecordDTO>> getHabitRecords(@RequestParam String from, @RequestParam String to, @AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(service.getHabitRecords(user.getUsername(), from, to));
    }
}
