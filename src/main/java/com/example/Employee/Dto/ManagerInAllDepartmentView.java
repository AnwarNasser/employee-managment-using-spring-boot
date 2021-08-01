package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
@Data
@AllArgsConstructor
public class ManagerInAllDepartmentView {
    private BigInteger employeeId;
    private String firstName;
    private String lastName;
    private BigInteger departmentId;
    private String departmentName;

}
