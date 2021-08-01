package com.example.Employee.Department;

import com.example.Employee.Dto.DepartmentViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/save")
    public ComponyDepartment saveDepartmentDate(@RequestBody ComponyDepartment componyDepartment)
    {
        return departmentService.saveDepartmentData(componyDepartment);
    }
    @GetMapping("/all")
    public List<DepartmentViewDto> getAllDepartment()
    {
       return departmentService.getAllDepartment();
    }
    @GetMapping("/{id}")
    public ComponyDepartment getDepartmentById(@PathVariable Long id)
    {
        return departmentService.getAllDepartmentById(id);
    }
    @PutMapping("/{id}")
    public ComponyDepartment updateDepartmentBtId(@PathVariable Long id,@RequestBody ComponyDepartment componyDepartment)
    {
        return departmentService.updateDepartmentById(id,componyDepartment);
    }

}
