package com.example.Employee.EmployeeJob;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeJobRepository extends CrudRepository<EmployeeJob,Long> {
    @Query(value = "select * from employee_job",nativeQuery = true)
    Optional<List<EmployeeJob>> getAllJob();
    EmployeeJob findByJobName(String jobName);
}
