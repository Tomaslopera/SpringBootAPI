package com.example.trabajo_1.dao;

import com.example.trabajo_1.models.RevengePlan;
import com.example.trabajo_1.models.SuccessLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IRevengePlanDAO extends JpaRepository<RevengePlan, Long> {
    // Buscar todos los planes de un bully específico
    List<RevengePlan> findAllByBullyId(Long bullyId);

    // Buscar por estado de ejecución
    default List<RevengePlan> findAllByIsExecuted(boolean executed) {
        return null;
    }

    // Buscar por fecha planeada
    List<RevengePlan> findAllByDatePlanned(LocalDate date);

    // Buscar por nivel de éxito
    List<RevengePlan> findAllBySuccessLevel(SuccessLevel successLevel);
}
