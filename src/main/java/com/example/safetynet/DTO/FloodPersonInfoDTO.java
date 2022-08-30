package com.example.safetynet.DTO;

import com.example.safetynet.model.MedicalRecord;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FloodPersonInfoDTO {

    private String lastName;
    private String phone;
    private Integer age;
    private MedicalRecord medicalRecord;

}
