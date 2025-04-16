package com.healthcareApp.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {
    private int billId;
    private int bill;
    private int totalBill;
    private int personId;
}
