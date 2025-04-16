package com.healthcareApp.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNo;
    private String speciality;
    private int experience;
}
