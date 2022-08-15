package com.example.safetynet.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "person")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private String city;
    @NonNull
    private String zip;
    @NonNull
    private String phone;
    @NonNull
    private String email;
}
