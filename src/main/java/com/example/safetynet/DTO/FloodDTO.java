package com.example.safetynet.DTO;

import java.util.List;

public interface FloodDTO {

    String getAddress();
    String getLast_name();
    String getPhone();
    String getBirthdate();
    List<String> getMedications();
    List<String> getAllergies();

}
