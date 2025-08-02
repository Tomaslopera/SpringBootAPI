package com.example.trabajo_1.dto;

import com.example.trabajo_1.models.SuccessLevel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RevengePlanDTO {
    private String title;
    private String description;
    private Long bullyId;
    private boolean isExecuted;
    private LocalDate datePlanned;
    private SuccessLevel successLevel;
}
