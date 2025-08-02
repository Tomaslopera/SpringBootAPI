package com.example.trabajo_1.dto;

import lombok.Data;
import com.example.trabajo_1.models.MediaType;

@Data
public class MediaDTO {
    private Long revengePlanId;
    private MediaType type;
    private String url;
    private String caption;
}
