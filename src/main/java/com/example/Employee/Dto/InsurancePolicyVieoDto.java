package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyVieoDto {
    private Long insurancePolicyId;
    private String insurancePolicyName;
    private Long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private Long childId;
    private String childName;
}
