package com.example.trabajo_1.dao;

import com.example.trabajo_1.models.Bully;
import com.example.trabajo_1.models.HighSchoolRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBullyDAO extends JpaRepository<Bully, Long> {
    // Buscar por nombre exacto
    Optional<Bully> findBullyByName(String name);

    // Buscar por nivel de molestia mayor a un valor
    List<Bully> findAllByLevelOfAnnoyanceGreaterThan(int level);

    // Buscar por rol en secundaria
    List<Bully> findAllByHighSchoolRole(HighSchoolRole role);

    // Buscar todos por clique
    List<Bully> findAllByCliqueId(Long cliqueId);
}
