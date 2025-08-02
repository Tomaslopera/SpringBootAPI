package com.example.trabajo_1.services;

import com.example.trabajo_1.dao.IMediaDAO;
import com.example.trabajo_1.dao.IRevengePlanDAO;
import com.example.trabajo_1.dto.MediaDTO;
import com.example.trabajo_1.models.Media;
import com.example.trabajo_1.models.RevengePlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final IMediaDAO mediaDao;
    private final IRevengePlanDAO revengeDao;

    public Media createMedia(MediaDTO dto) {
        RevengePlan plan = revengeDao.findById(dto.getRevengePlanId())
                .orElseThrow(() -> new RuntimeException("Plan de venganza no encontrado"));

        Media m = new Media();
        m.setRevengePlan(plan);
        m.setType(dto.getType());
        m.setUrl(dto.getUrl());
        m.setCaption(dto.getCaption());

        return mediaDao.save(m);
    }

    public List<Media> getMediaByPlan(Long planId) {
        return mediaDao.findAllByRevengePlanId(planId);
    }

}
