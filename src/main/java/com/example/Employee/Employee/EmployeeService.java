package com.example.Employee.Employee;

import com.example.Employee.ConvertService;
import com.example.Employee.Department.ComponyDepartment;
import com.example.Employee.Department.DepartmentService;
import com.example.Employee.Dto.*;
import com.example.Employee.EmployeeJob.EmployeeJob;
import com.example.Employee.EmployeeJob.EmployeeJobService;
import com.example.Employee.InsurancePolicyForEmployee.InsurancePolicyForEmployee;

import com.example.Employee.exception.RecordExistException;
import com.example.Employee.exception.ResourceNotFoundException;
import com.mysql.cj.log.LogFactory;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ConvertService convertService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeJobService employeeJobService;


    public EmployeeVieoDto saveEmployee(EmployeeDataSaveDtoById employeeDataSaveDtoById) {
         if(employeeRepository.findByFirstName(employeeDataSaveDtoById.getFirstName())!= null) {
             throw new RecordExistException("Another record Exit with same title ");
         }
         // employeeRepository.getEmployeeByTitle(employeeDataSaveDtoById.getFirstName()).orElseThrow(() -> new RecordExistException("Another record with same title Exite"));
            ComponyDepartment department = departmentService.getAllDepartmentById(employeeDataSaveDtoById.getDepartmentId());
            EmployeeJob employeeJob = employeeJobService.getJobById(employeeDataSaveDtoById.getJobId());
            return convertAndSave(employeeDataSaveDtoById.getFirstName(), employeeDataSaveDtoById.getLastName(), employeeDataSaveDtoById.getTelephone(), employeeDataSaveDtoById.getMobile(), employeeDataSaveDtoById.getSalary(), employeeDataSaveDtoById.getActive(), department, employeeJob);

        }
    public EmployeeVieoDto convertAndSave(String firstName, String lastName, String telephone, String mobile, String salary, Boolean active, ComponyDepartment department, EmployeeJob employeeJob) {
        EmployeeData employeeData = new EmployeeData();
        employeeData.setFirstName(firstName);
        employeeData.setLastName(lastName);
        employeeData.setTelephone(telephone);
        employeeData.setMobile(mobile);
        employeeData.setSalary(salary);
        employeeData.setActive(true);
        employeeData.setComponyDepartment(department);
        employeeRepository.save(employeeData);
        EmployeeVieoDto employeeVieoDto = new EmployeeVieoDto(employeeData.getEmployeeId(), employeeData.getFirstName(), employeeData.getLastName(), employeeData.getTelephone(), employeeData.getMobile(), employeeData.getSalary(), employeeData.getActive(), department.getDepartmentId(), department.getDepartmentName(), employeeJob.getJobId(), employeeJob.getJobName(), employeeJob.getJobDescription());
        return employeeVieoDto;
    }

    public List<EmployeeVieoDto> getAllEmployee() {
        List<EmployeeData> employeeDetaiels = employeeRepository.getAllEmployee().orElse(new ArrayList<>());
        return employeeDetaiels.stream().map(convertService::convertEmployeeToDto).collect(Collectors.toList());
    }

    public EmployeeData getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public EmployeeVieoDto updateEmployeeById(Long id, EmployeeDataSaveDtoById employeeDataSaveDtoById) {
        EmployeeData employeeData1 = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for id = " + id));
        ComponyDepartment department = departmentService.getAllDepartmentById(employeeDataSaveDtoById.getDepartmentId());
        EmployeeJob employeeJob = employeeJobService.getJobById(employeeDataSaveDtoById.getJobId());
        employeeData1.setFirstName(employeeDataSaveDtoById.getFirstName());
        employeeData1.setLastName(employeeDataSaveDtoById.getLastName());
        employeeData1.setTelephone(employeeDataSaveDtoById.getTelephone());
        employeeData1.setMobile(employeeDataSaveDtoById.getMobile());
        employeeData1.setSalary(employeeDataSaveDtoById.getSalary());
        employeeData1.setActive(employeeDataSaveDtoById.getActive());
        employeeData1.setComponyDepartment(department);
        employeeData1.setEmployeeJob(employeeJob);
        employeeRepository.save(employeeData1);
        EmployeeVieoDto employeeVieoDto = new EmployeeVieoDto(employeeData1.getEmployeeId(), employeeData1.getFirstName(), employeeData1.getLastName(), employeeData1.getTelephone(), employeeData1.getMobile(), employeeData1.getSalary(), employeeData1.getActive(), department.getDepartmentId(), department.getDepartmentName(), employeeJob.getJobId(), employeeJob.getJobName(), employeeJob.getJobDescription());
        return employeeVieoDto;
    }

    public EmployeeData deleteEmployee(Long id, EmployeeData employeeData) {
        EmployeeData employeeData1 = employeeRepository.findById(id).get();
        employeeData1.setActive(false);
        return employeeRepository.save(employeeData);
    }

    public EmployeeNoInEachDepartmentView getEmployeeNoInEachDepartment(Long departmentId) {
        Object[] objects = employeeRepository.getEmployeeNoInEachDepartment(departmentId).orElseThrow(() -> new ResourceNotFoundException("No employee for department " + departmentId)).get(0);
        return new EmployeeNoInEachDepartmentView((BigInteger) objects[0], (String) objects[1], (BigInteger) objects[2]);
    }

    public List<EmployeeNoInEachDepartmentView> getEmployeeInAllDepartment() {
        return employeeRepository.getEmployeeNoInAllDepartment().orElse(new ArrayList<>()).stream()
                .map(obj -> {
                    return new EmployeeNoInEachDepartmentView((BigInteger) obj[0], (String) obj[1], (BigInteger) obj[2]);
                }).collect(Collectors.toList());

    }

    public List<EmployeeMaxSalaryView> getEmployeeMaxSalary() {
        return employeeRepository.getEmployeeMaxSalary().orElse(new ArrayList<>()).stream()
                .map(obj -> {
                    return new EmployeeMaxSalaryView((BigInteger) obj[0], (String) obj[1], (String) obj[2], (String) obj[3]);
                }).collect(Collectors.toList());
    }

    public List<EmployeeMinSalary> getEmployeeMinSalary() {
        return employeeRepository.getEmployeeMinSalary().orElse(new ArrayList<>()).stream()
                .map(obj -> {
                    return new EmployeeMinSalary((BigInteger) obj[0], (String) obj[1], (String) obj[2], (String) obj[3]);
                }).collect(Collectors.toList());
    }

    public List<SumSalaryInAllDepartment> getEmployeeSalaryInAllDepartment() {
        List<Object[]> salaryDetails = employeeRepository.getSumSalaryInAllDepartment().orElse(new ArrayList<>());
        return salaryDetails.stream()
                .map(obj -> {
                    return new SumSalaryInAllDepartment((BigInteger) obj[0], (String) obj[1], (double) obj[2]);
                }).collect(Collectors.toList());
    }

    public SumSalaryInAllDepartment getEmployeeSalaryInEachDepartment(Long id) {
        Object[] objects = employeeRepository.getEmployeeSalaryEachDepartment(id).orElseThrow(() -> new ResourceNotFoundException("department not found " + id)).get(0);
        return new SumSalaryInAllDepartment((BigInteger) objects[0], (String) objects[1], (double) objects[2]);
    }

    public List<SumSalaryInAllDepartment> getEmployeeAvrageSalaryInAllDepartment() {
        List<Object[]> salaryDetails = employeeRepository.getSumSalaryInAllDepartment().orElse(new ArrayList<>());
        return salaryDetails.stream()
                .map(obj -> {
                    return new SumSalaryInAllDepartment((BigInteger) obj[0], (String) obj[1], (double) obj[2]);
                }).collect(Collectors.toList());


    }

    public List<ChildForEmployeeView> getchildForAllEmployee() {
        List<Object[]> childDetails = employeeRepository.getChildForAllEmployee().orElse(new ArrayList<>());
        return childDetails.stream().map(obj -> {
            return new ChildForEmployeeView((BigInteger) obj[0], (BigInteger) obj[1]);
        }).collect(Collectors.toList());
    }

    public ChildForEmployeeView getchildForEachEmployee(Long id) {
        Object[] obj = employeeRepository.getChildForEachEmployee(id).orElseThrow(() -> new ResourceNotFoundException("not found" + id)).get(0);
        return new ChildForEmployeeView((BigInteger) obj[0], (BigInteger) obj[1]);
    }

    public List<ManagerInAllDepartmentView> getAllManagerInAllDepartment() {
        return employeeRepository.getAllManagerInAllDepartment().orElse(new ArrayList<>()).stream()
                .map(obj -> {
                    return new ManagerInAllDepartmentView((BigInteger) obj[0], (String) obj[1], (String) obj[2], (BigInteger) obj[3], (String) obj[4]);
                }).collect(Collectors.toList());
    }

    public ManagerInAllDepartmentView getManagerForEachDepartment(String name) {
        Object[] obj = employeeRepository.getManagerForEachDepartment(name).orElseThrow(() -> new ResourceNotFoundException("departmentName not found" + name)).get(0);
        return new ManagerInAllDepartmentView((BigInteger) obj[0], (String) obj[1], (String) obj[2], (BigInteger) obj[3], (String) obj[4]);
    }

    public List<managerSalaryOfAllDepartmentView> getManagerSalaryOfAllDepartment() {
        return employeeRepository.getManagerSalaryOfAllDepartment().orElse(new ArrayList<>()).stream()
                .map(obj -> {
                    return new managerSalaryOfAllDepartmentView((BigInteger) obj[0], (String) obj[1], (String) obj[2], (BigInteger) obj[3], (String) obj[4], (String) obj[5]);
                }).collect(Collectors.toList());
    }

   /* public List<EmployeeVieoDto> getVerifyEmployeeId(EmployeeDataSaveDtoById employeeDataSaveDtoById, Long id) {
        Object[] data = employeeRepository.verifyEmployeeId(id).orElseThrow(() -> new ResourceNotFoundException("not found" + id)).get(0);
        if (getVerifyEmployeeId(employeeDataSaveDtoById, id).isEmpty()) {
             saveEmployee(employeeDataSaveDtoById);
        }

        return saveEmployee(employeeDataSaveDtoById)
    }*/
 /*  public EmployeeData getEmployeeByName(Long id)
   {
       return employeeRepository.getEmployeeByName(id).orElseThrow(()-> new ResourceNotFoundException("Name not found" + id));
   }*/

}