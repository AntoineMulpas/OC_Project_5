package com.example.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "FireStation")
@Table(name = "fire_station")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FireStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String address;
    private String station;

}
