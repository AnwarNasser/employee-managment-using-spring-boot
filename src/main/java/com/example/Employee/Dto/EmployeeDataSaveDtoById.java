package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDataSaveDtoById {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String telephone;
    private String mobile;
    private String salary;
    private Boolean active;
    private Long departmentId;
    private Long jobId;


}
