package com.example.trabajo_1.dao;

import com.example.trabajo_1.models.MoodTracker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMoodTrackerDAO extends JpaRepository<MoodTracker, Long> {
    Optional<MoodTracker> findByDate(LocalDate date);

    // Buscar todos con nivel de ánimo mayor a cierto valor
    List<MoodTracker> findAllByMoodLevelGreaterThanEqual(int level);
}
