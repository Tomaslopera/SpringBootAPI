package com.example.trabajo_1.dto;

import com.example.trabajo_1.models.HighSchoolRole;
import lombok.Data;

@Data
public class BullyDTO {
    private String name;
    private String nickname;
    private HighSchoolRole highSchoolRole;
    private Long cliqueId;
    private String bullyingReason;
    private int levelOfAnnoyance;
}
