package com.example.trabajo_1.controller;

import com.example.trabajo_1.dto.MoodTrackerDTO;
import com.example.trabajo_1.models.MoodTracker;
import com.example.trabajo_1.services.MoodTrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/moodtracker")
@RequiredArgsConstructor
public class MoodTrackerController {

    private final MoodTrackerService moodService;

    @PostMapping("/")
    public ResponseEntity<MoodTracker> create(@RequestBody MoodTrackerDTO dto) {
        return ResponseEntity.ok(moodService.createLog(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<MoodTracker>> getAll() {
        return ResponseEntity.ok(moodService.getAllLogs());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<MoodTracker> getByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return moodService.getLogByDate(date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
