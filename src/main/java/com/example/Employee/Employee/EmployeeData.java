package com.example.Employee.Employee;

import com.example.Employee.Department.ComponyDepartment;
import com.example.Employee.EmployeeJob.EmployeeJob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String telephone;
    private String mobile;
    private String salary;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "departmentId")
    private ComponyDepartment componyDepartment;
    @ManyToOne
    @JoinColumn(name = "job_id",referencedColumnName = "jobId")
    private EmployeeJob employeeJob;
}
