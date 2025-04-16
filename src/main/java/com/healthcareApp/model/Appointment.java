package com.healthcareApp.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private int appointmentId;
    private int personId;
    private int doctorId;
    private int hospitalId;
    private int deptId;
}
