package com.example.safetynet.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FloodMedicalRecordDTO {

    private String[] medications;
    private String[] allergies;
}
