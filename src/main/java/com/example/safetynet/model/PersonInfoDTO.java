package com.example.safetynet.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfoDTO {

    private String lastName;
    private String address;
    private Integer age;
    private String email;
    private List<String> medications;
    private List<String> allergies;

}
