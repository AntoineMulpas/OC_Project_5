package com.example.safetynet.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FloodDTO {

   private String address;
   private FloodPersonInfoDTO floodPersonInfoDTO;

}
