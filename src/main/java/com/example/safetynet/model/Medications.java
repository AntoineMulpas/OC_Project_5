package com.example.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Medications")
@Table(name = "medications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medications {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String medicament;

}
