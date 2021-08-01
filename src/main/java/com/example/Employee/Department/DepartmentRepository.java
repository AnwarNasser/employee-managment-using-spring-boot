package com.example.Employee.Department;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<ComponyDepartment,Long> {
    @Query(value = "select * from compony_department ",nativeQuery = true)
    Optional<List<ComponyDepartment>> getAllDepartment();
    ComponyDepartment findByDepartmentName(String departmentName);
}
