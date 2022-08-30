package com.example.safetynet.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CountOfPersonDTO {

    private Long adultCount;
    private Long childCount;
}
