package com.example.trabajo_1.services;

import com.example.trabajo_1.dao.ICliqueDAO;
import com.example.trabajo_1.dto.CliqueDTO;
import com.example.trabajo_1.models.Clique;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CliqueService {
    private final ICliqueDAO cliqueDao;

    public Clique createClique(CliqueDTO dto) {
        Clique clique = new Clique();
        clique.setName(dto.getName());
        clique.setDescription(dto.getDescription());
        return cliqueDao.save(clique);
    }

    public List<Clique> getAllCliques() {
        return cliqueDao.findAll();
    }

    public Optional<Clique> getCliqueById(Long id) {
        return cliqueDao.findById(id);
    }
}
