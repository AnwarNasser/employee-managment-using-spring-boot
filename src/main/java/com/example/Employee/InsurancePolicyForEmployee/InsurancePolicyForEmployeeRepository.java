package com.example.Employee.InsurancePolicyForEmployee;

import com.example.Employee.Dto.InsurancePolicyVieoDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsurancePolicyForEmployeeRepository extends CrudRepository<InsurancePolicyForEmployee,Long> {
    @Query(value = "select * from insurance_policy_for_employee",nativeQuery = true)
    Optional<List<InsurancePolicyForEmployee>> getAllInsurancePolicy();
    InsurancePolicyForEmployee findByInsurancePolicyName(String name);
}
