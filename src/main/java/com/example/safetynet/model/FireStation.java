package com.example.safetynet.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "FireStation")
@Table(name = "fire_station")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FireStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String address;
    private String station;

}
