package com.example.safetynet.model;

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
