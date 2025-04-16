package com.healthcareApp.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int deptId;
    private String deptName;
    private int doctorId;
    private int hospitalId;
}
