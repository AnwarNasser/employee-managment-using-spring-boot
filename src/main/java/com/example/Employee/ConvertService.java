package com.example.Employee;

import com.example.Employee.Child.ChildData;
import com.example.Employee.Department.ComponyDepartment;
import com.example.Employee.Dto.*;
import com.example.Employee.Employee.EmployeeData;
import com.example.Employee.EmployeeJob.EmployeeJob;
import com.example.Employee.InsurancePolicyForEmployee.InsurancePolicyForEmployee;
//import com.example.Employee.Security.SecurityConfiguration;
//import com.example.Employee.User.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertService {
@Autowired
    private ModelMapper modelMapper;
    public ChildDataViewDto convertChildDataToDto(ChildData childData)
    {
        return modelMapper.map(childData,ChildDataViewDto.class);
    }
    public DepartmentViewDto convertDepartmentToDto(ComponyDepartment componyDepartment)
    {
        return modelMapper.map(componyDepartment,DepartmentViewDto.class);
    }
    public EmployeeVieoDto convertEmployeeToDto(EmployeeData employeeData)
    {
        return modelMapper.map(employeeData,EmployeeVieoDto.class);
    }
    public InsurancePolicyVieoDto convertInsurancePolicyToDto(InsurancePolicyForEmployee insurancePolicyForEmployee)
    {
        return modelMapper.map(insurancePolicyForEmployee,InsurancePolicyVieoDto.class);
    }
    public EmployeeJobViewDto convertEmployeeJobToDto(EmployeeJob employeeJob)
    {
        return modelMapper.map(employeeJob,EmployeeJobViewDto.class);
    }
    public EmployeeMaxSalaryView convertEmployeesalaryToDto(EmployeeData employeeData)
    {
        return modelMapper.map(employeeData,EmployeeMaxSalaryView.class);
    }
    public ChildForEmployeeView convertChildToDto(InsurancePolicyForEmployee insurancePolicyForEmployee)
    {
        return modelMapper.map(insurancePolicyForEmployee,ChildForEmployeeView.class);
    }
    /*public SecurityConfiguration.UserViewDto convertUserToDto(User user)
    {
        return modelMapper.map(user, SecurityConfiguration.UserViewDto.class);
    }*/
}
