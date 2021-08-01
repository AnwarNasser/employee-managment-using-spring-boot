package com.example.Employee.InsurancePolicyForEmployee;

import com.example.Employee.Child.ChildData;
import com.example.Employee.Child.ChildService;
import com.example.Employee.ConvertService;
import com.example.Employee.Dto.EmployeeDataSaveDtoById;
import com.example.Employee.Dto.InsurancePolicySaveDto;
import com.example.Employee.Dto.InsurancePolicyVieoDto;
import com.example.Employee.Employee.EmployeeData;
import com.example.Employee.Employee.EmployeeService;
import com.example.Employee.exception.RecordExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsurancePolicyForEmployeeService {
    @Autowired
    InsurancePolicyForEmployeeRepository insurancePolicyForEmployeeRepository;
    @Autowired
    ConvertService convertService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ChildService childService;
    int age;

    public InsurancePolicyVieoDto saveInsurancePolicy(InsurancePolicySaveDto insurancePolicySaveDto)
    {
           if (insurancePolicyForEmployeeRepository.findByInsurancePolicyName(insurancePolicySaveDto.getInsurancePolicyName())!=null)
           {
               throw new RecordExistException("Another record exit with same title");
           }
            EmployeeData employeeData = employeeService.getEmployeeById(insurancePolicySaveDto.getEmployeeId());
            ChildData childData = childService.getChildById(insurancePolicySaveDto.getChildId());
            return convertAndSave(insurancePolicySaveDto.getInsurancePolicyName(), employeeData, childData);

    }
    public InsurancePolicyVieoDto convertAndSave(String InsurancePolicyName,EmployeeData employeeData,ChildData childData)
    {
        InsurancePolicyForEmployee insuranceEmployee=new InsurancePolicyForEmployee();
        insuranceEmployee.setInsurancePolicyName(InsurancePolicyName);
        insuranceEmployee.setEmployeeData(employeeData);
        insuranceEmployee.setChildData(childData);
        insurancePolicyForEmployeeRepository.save(insuranceEmployee);
        InsurancePolicyVieoDto insurancePolicyVieoDto=new InsurancePolicyVieoDto(insuranceEmployee.getInsurancePolicyId(),insuranceEmployee.getInsurancePolicyName(),employeeData.getEmployeeId(),employeeData.getFirstName(),employeeData.getLastName(),childData.getChildId(),childData.getChildName());
        return insurancePolicyVieoDto;

    }
    public List<InsurancePolicyVieoDto> getAllInsurancePolicy()
    {
        List<InsurancePolicyForEmployee> insurancePolicyDetaiels=insurancePolicyForEmployeeRepository.getAllInsurancePolicy().orElse(new ArrayList<>());
        return insurancePolicyDetaiels.stream().map(convertService::convertInsurancePolicyToDto).collect(Collectors.toList());
    }
    public InsurancePolicyForEmployee getInsurancePolicyById(Long id)
    {
        return insurancePolicyForEmployeeRepository.findById(id).get();
    }
    public InsurancePolicyVieoDto updateInsurancePolicy(Long id, InsurancePolicySaveDto insurancePolicySaveDto)
    {
        InsurancePolicyForEmployee insurancePolicyForEmployee1=insurancePolicyForEmployeeRepository.findById(id).get();
        EmployeeData employeeData=employeeService.getEmployeeById(insurancePolicySaveDto.getEmployeeId());
        ChildData childData=childService.getChildById(insurancePolicySaveDto.getChildId());
        insurancePolicyForEmployee1.setInsurancePolicyName(insurancePolicySaveDto.getInsurancePolicyName());
        insurancePolicyForEmployee1.setEmployeeData(employeeData);
        insurancePolicyForEmployee1.setChildData(childData);
        insurancePolicyForEmployeeRepository.save(insurancePolicyForEmployee1);
        InsurancePolicyVieoDto insurancePolicyVieoDto=new InsurancePolicyVieoDto(insurancePolicyForEmployee1.getInsurancePolicyId(),insurancePolicyForEmployee1.getInsurancePolicyName(),employeeData.getEmployeeId(),employeeData.getFirstName(),employeeData.getLastName(),childData.getChildId(),childData.getChildName());
        return insurancePolicyVieoDto;
    }
}
