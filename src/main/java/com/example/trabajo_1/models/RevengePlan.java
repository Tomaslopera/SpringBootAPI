package com.example.trabajo_1.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevengePlan {
    @Id @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String description;

    @JoinColumn(name = "bully_id")
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Bully bully;

    private boolean isExecuted;
    private LocalDate datePlanned;

    @Enumerated(EnumType.STRING)
    private SuccessLevel successLevel;

    @OneToMany(mappedBy = "revengePlan", cascade = CascadeType.ALL)
    private List<Media> mediaEntries;
}
