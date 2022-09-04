package com.example.safetynet.model;

import com.example.safetynet.model.MedicalRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InhabitantsByAddressDTO {

    private String lastName;
    private String phone;
    private Integer age;
    private MedicalRecord medicalRecord;
    private String station;

}
