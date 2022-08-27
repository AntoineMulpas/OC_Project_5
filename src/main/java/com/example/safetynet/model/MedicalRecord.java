package com.example.safetynet.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "MedicalRecord")
@Table(name = "medical_record")
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
