package com.example.safetynet.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonCoveredByFireStationDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private CountOfPersonDTO countOfPersonDTO;

}
