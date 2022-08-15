package com.example.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity(name = "MedicalRecord")
@Table(name = "medical_record")
@Data
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
