package com.healthcareApp.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private String address;
    private String emailId;
    private String contactNo;
}
