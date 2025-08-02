package com.example.trabajo_1.dao;

import com.example.trabajo_1.models.Media;
import com.example.trabajo_1.models.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMediaDAO extends JpaRepository<Media, Long> {

    // Buscar todas las medias asociadas a un plan de venganza
    List<com.example.trabajo_1.models.Media> findAllByRevengePlanId(Long revengePlanId);

    // Buscar por tipo de media
    List<Media> findAllByType(MediaType type);
}
