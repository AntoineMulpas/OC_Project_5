package com.example.safetynet.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonFireStationAndCountDTO {

    private PersonCoveredByFireStationDTO personCoveredByFireStationDTO;
    private  CountOfPersonDTO countOfPersonDTO;

}
