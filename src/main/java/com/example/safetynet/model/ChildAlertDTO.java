package com.example.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChildAlertDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<Person> familyMembers;

}
