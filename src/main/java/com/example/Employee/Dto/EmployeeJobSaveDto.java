package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeJobSaveDto {
    private String jobName;
    private String jobDescription;
}
