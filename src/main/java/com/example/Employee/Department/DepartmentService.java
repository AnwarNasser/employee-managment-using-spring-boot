package com.example.Employee.Department;

import com.example.Employee.ConvertService;
import com.example.Employee.Dto.DepartmentViewDto;
import com.example.Employee.exception.RecordExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ConvertService convertService;
    public ComponyDepartment saveDepartmentData(ComponyDepartment componyDepartment)
    {
        if (departmentRepository.findByDepartmentName(componyDepartment.getDepartmentName())!=null)
        {
            throw new RecordExistException("Another record exit with same title");
        }
        departmentRepository.save(componyDepartment);
        return componyDepartment;
    }
    public List<DepartmentViewDto> getAllDepartment()
    {
        List<ComponyDepartment> departmentDetails= departmentRepository.getAllDepartment().orElse(new ArrayList<>());
        return departmentDetails.stream().map(convertService::convertDepartmentToDto).collect(Collectors.toList());
    }
    public ComponyDepartment getAllDepartmentById(Long id)
    {
        return departmentRepository.findById(id).get();
    }
    public ComponyDepartment updateDepartmentById(Long id,ComponyDepartment componyDepartment)
    {
        ComponyDepartment componyDepartment1=departmentRepository.findById(id).get();
        componyDepartment1.setDepartmentName(componyDepartment.getDepartmentName());
        departmentRepository.save(componyDepartment1);
        return componyDepartment1;
    }
}
