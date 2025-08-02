package com.example.trabajo_1.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private RevengePlan revengePlan;

    @Enumerated(EnumType.STRING)
    private MediaType type;

    private String url;
    private String caption;
}
