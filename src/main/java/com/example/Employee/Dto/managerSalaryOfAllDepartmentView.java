package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
@Data
@AllArgsConstructor
public class managerSalaryOfAllDepartmentView {
    private BigInteger employeeId;
    private String firstName;
    private String lastName;
    private BigInteger departmentId;
    private String departmentName;
    private String salary;
}
