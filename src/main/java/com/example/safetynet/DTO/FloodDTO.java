package com.example.safetynet.DTO;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FloodDTO {

   private String address;
   private FloodPersonInfoDTO floodPersonInfoDTO;

}
