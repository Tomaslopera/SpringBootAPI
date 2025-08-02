package com.example.trabajo_1.controller;

import com.example.trabajo_1.dto.BullyDTO;
import com.example.trabajo_1.models.Bully;
import com.example.trabajo_1.services.BullyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bullies")
@RequiredArgsConstructor
public class BullyController {

    private final BullyService bullyService;

    @PostMapping("/")
    public ResponseEntity<Bully> create(@RequestBody BullyDTO dto) {
        return ResponseEntity.ok(bullyService.createBully(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<Bully>> getAll() {
        return ResponseEntity.ok(bullyService.getAllBullies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bully> getById(@PathVariable Long id) {
        return bullyService.getBullyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bullyService.deleteBully(id);
        return ResponseEntity.noContent().build();
    }
}
