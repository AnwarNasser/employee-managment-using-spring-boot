package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeNoInEachDepartmentView {
    private BigInteger departmentId;
    private String departmentName;
    private BigInteger EmployeeNo;
}
