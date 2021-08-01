package com.example.Employee.Employee;

import com.example.Employee.Dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/EmployeeDate")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public EmployeeVieoDto saveEmployee(@RequestBody EmployeeDataSaveDtoById employeeDataSaveDtoById)
    {
        return employeeService.saveEmployee(employeeDataSaveDtoById);
    }
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public List<EmployeeVieoDto> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }
    @RequestMapping(value="/admin/{id}", method=RequestMethod.GET)
    public EmployeeData getEmployeeById(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }
    @RequestMapping(value="/admin/{id}", method=RequestMethod.PUT)
    public EmployeeVieoDto updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDataSaveDtoById employeeDataSaveDtoById)
    {
        return employeeService.updateEmployeeById(id,employeeDataSaveDtoById);
    }
    @RequestMapping(value="/admin/{id}", method=RequestMethod.DELETE)
    public EmployeeData deleteEmployee(@PathVariable Long id,@RequestBody EmployeeData employeeData)
    {
        return employeeService.deleteEmployee(id,employeeData);
    }
    @GetMapping("/employeeNoEachDepartment/{departmentId}")
    public EmployeeNoInEachDepartmentView getEmployeeNoInEachDepartment(@PathVariable Long departmentId)
    {
        return employeeService.getEmployeeNoInEachDepartment(departmentId);
    }
    @GetMapping("/employeeInAllDepartment")
    public List<EmployeeNoInEachDepartmentView> getEmployeeInAllDepartment()
    {
        return employeeService.getEmployeeInAllDepartment();
    }
    @GetMapping("/employeeMaxSalary")
    public List<EmployeeMaxSalaryView> getEmployeeMaxSalary()
    {
        return employeeService.getEmployeeMaxSalary();
    }
    @GetMapping("/employeeMinSalary")
    public List<EmployeeMinSalary> getEmployeeMinSalary()
    {
        return employeeService.getEmployeeMinSalary();
    }
    @GetMapping("/sumSalaryInAlldepartment")
     public List<SumSalaryInAllDepartment> getEmployeeSalaryInAllDepartment()
    {
        return employeeService.getEmployeeSalaryInAllDepartment();
    }
    @GetMapping("/sumSalaryInEachDepartment/{id}")
    public SumSalaryInAllDepartment getEmployeeSalaryInEachDepartment(@PathVariable Long id)
    {
        return employeeService.getEmployeeSalaryInEachDepartment(id);
    }
    @GetMapping("/avarageSalaryInEachDepartment")
    public List<SumSalaryInAllDepartment> getEmployeeAvrageSalaryInEachDepartment()
    {
        return employeeService.getEmployeeAvrageSalaryInAllDepartment();
    }
    @GetMapping("/childForAllEmployee")
    public List<ChildForEmployeeView> getchildForAllEmployee()
    {
        return employeeService.getchildForAllEmployee();
    }
    @GetMapping("/childForEachDepartment/{id}")
    public ChildForEmployeeView getchildForEachEmployee(@PathVariable Long id)
    {
        return employeeService.getchildForEachEmployee(id);
    }
    @GetMapping("/managerInAllDepartment")
    public List<ManagerInAllDepartmentView> getAllManagerInAllDepartment()
    {
        return employeeService.getAllManagerInAllDepartment();
    }
    @GetMapping("/managerForEachDepartment/{name}")
    public ManagerInAllDepartmentView getManagerForEachDepartment(@PathVariable @Param(value = "name") String name)
    {
        return employeeService.getManagerForEachDepartment(name);
    }
    @GetMapping("/managerSalaryOfAllDepartment")
    public List<managerSalaryOfAllDepartmentView> getManagerSalaryOfAllDepartment()
    {
        return employeeService.getManagerSalaryOfAllDepartment();
    }
   /* @GetMapping("/verifyEmployeeId")
    public List<EmployeeVieoDto> getVerifyEmployeeId(@RequestBody EmployeeDataSaveDtoById employeeDataSaveDtoById,@PathVariable Long id)
    {
        return employeeService.getVerifyEmployeeId(employeeDataSaveDtoById,id);
    }*/
  /* @GetMapping("/employeeByName/{id}")
    public EmployeeData getEmployeeByName(@PathVariable Long id)
   {
       return employeeService.getEmployeeByName(id);
   }*/
}
