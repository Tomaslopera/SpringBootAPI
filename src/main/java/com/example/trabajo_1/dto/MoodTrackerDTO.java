package com.example.trabajo_1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MoodTrackerDTO {
    private LocalDate date;
    private int moodLevel;
    private String note;
}
