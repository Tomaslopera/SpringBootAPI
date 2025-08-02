package com.example.trabajo_1.services;

import com.example.trabajo_1.dao.IBullyDAO;
import com.example.trabajo_1.dao.ICliqueDAO;
import com.example.trabajo_1.dto.BullyDTO;
import com.example.trabajo_1.models.Bully;
import com.example.trabajo_1.models.Clique;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BullyService {

    private final IBullyDAO bullyDao;
    private final ICliqueDAO cliqueDao;

    public Bully createBully(BullyDTO dto) {
        Bully bully = new Bully();
        bully.setName(dto.getName());
        bully.setNickname(dto.getNickname());
        bully.setHighSchoolRole(dto.getHighSchoolRole());
        bully.setBullyingReason(dto.getBullyingReason());
        bully.setLevelOfAnnoyance(dto.getLevelOfAnnoyance());

        if (dto.getCliqueId() != null) {
            Clique clique = cliqueDao.findById(dto.getCliqueId()).orElseThrow(() -> new RuntimeException("Clique no encontrada"));
            bully.setClique(clique);
        }

        return bullyDao.save(bully);
    }

    public List<Bully> getAllBullies() {
        return bullyDao.findAll();
    }

    public Optional<Bully> getBullyById(Long id) {
        return bullyDao.findById(id);
    }

    public void deleteBully(Long id) {
        bullyDao.deleteById(id);
    }
}
