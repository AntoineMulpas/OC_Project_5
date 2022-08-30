package com.example.safetynet.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonCoveredByFireStationDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private CountOfPersonDTO countOfPersonDTO;

}
