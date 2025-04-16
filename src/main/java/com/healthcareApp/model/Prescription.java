package com.healthcareApp.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private int prescriptionId;
    private String prescriptionDetails;
    private int personId;
}
