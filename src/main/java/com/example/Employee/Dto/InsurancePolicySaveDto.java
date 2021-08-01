package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicySaveDto {
    private Long insurancePolicyId;
    private String insurancePolicyName;
    private Long employeeId;
    private Long childId;

}
