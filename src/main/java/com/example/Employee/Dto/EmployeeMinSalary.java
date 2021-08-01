package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMinSalary {
    private BigInteger employeeId;
    private String firstName;
    private String lastName;
    private String minSalary;
}
