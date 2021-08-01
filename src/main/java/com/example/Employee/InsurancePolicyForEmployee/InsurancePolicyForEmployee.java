package com.example.Employee.InsurancePolicyForEmployee;

import com.example.Employee.Child.ChildData;
import com.example.Employee.Employee.EmployeeData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyForEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insurancePolicyId;
    private String insurancePolicyName;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
    private EmployeeData employeeData;

    @ManyToOne
    @JoinColumn(name = "child_d",referencedColumnName = "childId")
    private ChildData childData;
}
