package com.example.trabajo_1.controller;

import com.example.trabajo_1.dto.RevengePlanDTO;
import com.example.trabajo_1.models.RevengePlan;
import com.example.trabajo_1.services.RevengePlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revengeplan")
@RequiredArgsConstructor
public class RevengePlanController {
    private final RevengePlanService planService;

    @PostMapping("/")
    public ResponseEntity<RevengePlan> create(@RequestBody RevengePlanDTO dto) {
        return ResponseEntity.ok(planService.createPlan(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<RevengePlan>> getAll() {
        return ResponseEntity.ok(planService.getAllPlans());
    }

    @GetMapping("/bully/{bullyId}")
    public ResponseEntity<List<RevengePlan>> getByBully(@PathVariable Long bullyId) {
        return ResponseEntity.ok(planService.getPlansByBully(bullyId));
    }
}
