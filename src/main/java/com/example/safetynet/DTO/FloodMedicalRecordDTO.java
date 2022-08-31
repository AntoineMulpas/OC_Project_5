package com.example.safetynet.DTO;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FloodMedicalRecordDTO {

    private String[] medications;
    private String[] allergies;
}
