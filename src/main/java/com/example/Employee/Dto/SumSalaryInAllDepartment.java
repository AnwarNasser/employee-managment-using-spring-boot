package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumSalaryInAllDepartment {
    private BigInteger departmentId;
    private String departmentName;
    private double totalSalary;
}
