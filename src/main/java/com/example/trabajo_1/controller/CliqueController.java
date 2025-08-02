package com.example.trabajo_1.controller;

import com.example.trabajo_1.dto.CliqueDTO;
import com.example.trabajo_1.models.Clique;
import com.example.trabajo_1.services.CliqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliques")
@RequiredArgsConstructor
public class CliqueController {
    private final CliqueService cliqueService;

    @PostMapping("/")
    public ResponseEntity<Clique> create(@RequestBody CliqueDTO dto) {
        return ResponseEntity.ok(cliqueService.createClique(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<Clique>> getAll() {
        return ResponseEntity.ok(cliqueService.getAllCliques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clique> getById(@PathVariable Long id) {
        return cliqueService.getCliqueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
