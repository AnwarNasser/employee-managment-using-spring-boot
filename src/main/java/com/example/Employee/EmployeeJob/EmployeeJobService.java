package com.example.Employee.EmployeeJob;

import com.example.Employee.ConvertService;
import com.example.Employee.Dto.EmployeeJobViewDto;
import com.example.Employee.Employee.EmployeeService;
import com.example.Employee.exception.RecordExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeJobService {
    @Autowired
    EmployeeJobRepository employeeJobRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ConvertService convertService;

     public EmployeeJob saveJob(EmployeeJob employeeJob)
     {
         if(employeeJobRepository.findByJobName(employeeJob.getJobName())!=null)
         {
             throw new RecordExistException("Another recorde exite with same title");
         }
         return employeeJobRepository.save(employeeJob);
     }
    public List<EmployeeJobViewDto> getAllJob() {
         List<EmployeeJob> jobDetails = employeeJobRepository.getAllJob().orElse(new ArrayList<>());
         return jobDetails.stream().map(convertService::convertEmployeeJobToDto).collect(Collectors.toList());

     }
    public EmployeeJob getJobById(Long id)
    {
        return employeeJobRepository.findById(id).get();
    }
    public EmployeeJob updateJob(EmployeeJob employeeJob,Long id)
    {
        EmployeeJob employeeJob1=employeeJobRepository.findById(id).get();
        employeeJob1.setJobName(employeeJob.getJobName());
        employeeJob1.setJobDescription(employeeJob.getJobDescription());
        return employeeJobRepository.save(employeeJob1);
    }
}
