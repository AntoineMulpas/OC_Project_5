package com.example.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "MedicalRecord")
@Table(name = "medical_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String birthdate;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private String[] medications;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private String[] allergies;




}
