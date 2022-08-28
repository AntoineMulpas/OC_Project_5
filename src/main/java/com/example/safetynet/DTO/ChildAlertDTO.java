package com.example.safetynet.DTO;

import com.example.safetynet.model.Person;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ChildAlertDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<Person> familyMembers;

}
