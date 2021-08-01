package com.example.Employee.InsurancePolicyForEmployee;

import com.example.Employee.Dto.InsurancePolicySaveDto;
import com.example.Employee.Dto.InsurancePolicyVieoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurancePolicy")
public class InsuraceRepositoryForEmployeeController {
    @Autowired
    InsurancePolicyForEmployeeService insurancePolicyForEmployeeService;
    @PostMapping()
    public InsurancePolicyVieoDto saveInsurancePolicy(@RequestBody InsurancePolicySaveDto insurancePolicySaveDto)
    {
        return insurancePolicyForEmployeeService.saveInsurancePolicy(insurancePolicySaveDto);
    }
    @GetMapping()
    public List<InsurancePolicyVieoDto> getAllInsurancePolicy()
    {
        return insurancePolicyForEmployeeService.getAllInsurancePolicy();
    }
    @GetMapping("/{id}")
    public InsurancePolicyForEmployee getInsurancePolicyById(@PathVariable Long id)
    {
        return insurancePolicyForEmployeeService.getInsurancePolicyById(id);
    }
    @PutMapping("/{id}")
    public InsurancePolicyVieoDto updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicySaveDto insurancePolicySaveDto)
    {
        return insurancePolicyForEmployeeService.updateInsurancePolicy(id,insurancePolicySaveDto);
    }

}
