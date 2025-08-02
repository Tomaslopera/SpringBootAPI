package com.example.trabajo_1.controller;

import com.example.trabajo_1.dto.MediaDTO;
import com.example.trabajo_1.models.Media;
import com.example.trabajo_1.services.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/")
    public ResponseEntity<Media> create(@RequestBody MediaDTO dto) {
        return ResponseEntity.ok(mediaService.createMedia(dto));
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<List<Media>> getByPlan(@PathVariable Long planId) {
        return ResponseEntity.ok(mediaService.getMediaByPlan(planId));
    }
}
