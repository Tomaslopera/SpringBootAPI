package com.example.trabajo_1.services;

import com.example.trabajo_1.dao.IBullyDAO;
import com.example.trabajo_1.dao.IRevengePlanDAO;
import com.example.trabajo_1.dto.RevengePlanDTO;
import com.example.trabajo_1.models.Bully;
import com.example.trabajo_1.models.RevengePlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RevengePlanService {
    private final IRevengePlanDAO revengeDao;
    private final IBullyDAO bullyDao;

    public RevengePlan createPlan(RevengePlanDTO dto) {
        Bully bully = bullyDao.findById(dto.getBullyId()).orElseThrow(() -> new RuntimeException("Bully no encontrado"));
        RevengePlan plan = new RevengePlan();
        plan.setTitle(dto.getTitle());
        plan.setDescription(dto.getDescription());
        plan.setBully(bully);
        plan.setExecuted(dto.isExecuted());
        plan.setDatePlanned(dto.getDatePlanned());
        plan.setSuccessLevel(dto.getSuccessLevel());

        return revengeDao.save(plan);
    }

    public List<RevengePlan> getAllPlans() {
        return revengeDao.findAll();
    }

    public List<RevengePlan> getPlansByBully(Long bullyId) {
        return revengeDao.findAllByBullyId(bullyId);
    }
}
