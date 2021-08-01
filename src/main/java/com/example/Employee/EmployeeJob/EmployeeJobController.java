package com.example.Employee.EmployeeJob;

import com.example.Employee.Dto.EmployeeJobViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeJob")
public class EmployeeJobController {
    @Autowired
    EmployeeJobService employeeJobService;
    @PostMapping()
    public EmployeeJob saveJob(@RequestBody EmployeeJob employeeJob)
    {
        return employeeJobService.saveJob(employeeJob);
    }
    @GetMapping()
    public List<EmployeeJobViewDto> getAllJob()
    {
        return employeeJobService.getAllJob();
    }
    @GetMapping("/{id}")
    public EmployeeJob getJobById(@PathVariable Long id)
    {
        return employeeJobService.getJobById(id);
    }
    @PutMapping("/{id}")
    public EmployeeJob updateJob(@RequestBody EmployeeJob employeeJob,@PathVariable Long id)
    {
        return employeeJobService.updateJob(employeeJob,id);
    }

}
