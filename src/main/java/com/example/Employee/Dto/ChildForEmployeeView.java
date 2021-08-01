package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class ChildForEmployeeView {
    private BigInteger employeeId;
    private BigInteger childNo;
}
