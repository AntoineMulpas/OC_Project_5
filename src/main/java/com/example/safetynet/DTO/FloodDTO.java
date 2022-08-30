package com.example.safetynet.DTO;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FloodDTO {

   private String address;
   private FloodPersonInfoDTO floodPersonInfoDTO;

}
