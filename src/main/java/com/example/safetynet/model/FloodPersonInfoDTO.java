package com.example.safetynet.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FloodPersonInfoDTO {

    private String lastName;
    private String phone;
    private Integer age;
    private FloodMedicalRecordDTO floodMedicalRecordDTO;

}
