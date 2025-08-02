package com.example.trabajo_1.dao;

import com.example.trabajo_1.models.Clique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICliqueDAO extends JpaRepository<Clique, Long> {
    // Buscar por nombre exacto
    Optional<Clique> findCliqueByName(String name);
}
