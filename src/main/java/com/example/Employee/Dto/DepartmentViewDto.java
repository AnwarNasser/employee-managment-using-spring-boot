package com.example.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentViewDto {
    private Long departmentId;
    private String departmentName;
}
