package com.example.trabajo_1.services;

import com.example.trabajo_1.dao.IMoodTrackerDAO;
import com.example.trabajo_1.dto.MoodTrackerDTO;
import com.example.trabajo_1.models.MoodTracker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoodTrackerService {

    private final IMoodTrackerDAO moodDao;

    public MoodTracker createLog(MoodTrackerDTO dto) {
        MoodTracker log = new MoodTracker();
        log.setDate(dto.getDate());
        log.setMoodLevel(dto.getMoodLevel());
        log.setNote(dto.getNote());
        return moodDao.save(log);
    }

    public List<MoodTracker> getAllLogs() {
        return moodDao.findAll();
    }

    public Optional<MoodTracker> getLogByDate(LocalDate date) {
        return moodDao.findByDate(date);
    }
}
