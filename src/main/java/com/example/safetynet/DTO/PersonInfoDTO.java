package com.example.safetynet.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
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
