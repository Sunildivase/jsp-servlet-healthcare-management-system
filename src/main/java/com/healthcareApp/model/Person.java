package com.healthcareApp.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Person {
    private String personId;
    private String type;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String contactNo;
    private String alternateMobile;
    private String address;
}
