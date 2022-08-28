package com.example.safetynet.DTO;

import java.util.List;

public interface InhabitantsByAddressDTO {

    String getStation();
    String getLast_name();
    String getPhone();
    String getBirthdate();
    List<String> getMedications();
    List<String> getAllergies();

}
