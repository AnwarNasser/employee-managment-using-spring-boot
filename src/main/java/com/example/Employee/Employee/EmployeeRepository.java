package com.example.Employee.Employee;

import com.example.Employee.InsurancePolicyForEmployee.InsurancePolicyForEmployee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeData,Long> {
    @Query(value = "select * from employee_data",nativeQuery = true)
    Optional<List<EmployeeData>> getAllEmployee();
    @Query(value = "select d.department_id ,d.department_name,count(e.employee_id) from company_db.compony_department d,company_db.employee_data e where d.department_id=e.department_id and e.department_id= :department_id limit 1",nativeQuery = true)
    Optional<List<Object[]>>getEmployeeNoInEachDepartment(@Param(value = "department_id")Long department_id );
    @Query(value = " select d.department_id ,d.department_name,count(e.employee_id) from company_db.compony_department d,company_db.employee_data e where d.department_id=e.department_id group by department_id",nativeQuery = true)
    Optional<List<Object[]>>getEmployeeNoInAllDepartment();
    @Query(value = " select e.employee_id,e.first_name,e.last_name,max(e.salary) from company_db.employee_data e where e.salary=(select max(salary) from company_db.employee_data e)",nativeQuery = true)
    Optional<List<Object[]>>getEmployeeMaxSalary();
    @Query(value = "select e.employee_id,e.first_name,e.last_name,min(e.salary) from company_db.employee_data e where e.salary=(select min(salary) from company_db.employee_data e)",nativeQuery = true)
    Optional<List<Object[]>>getEmployeeMinSalary();
    @Query(value = "select d.department_id,d.department_name,sum(e.salary) from company_db.compony_department d ,company_db.employee_data e where d.department_id = e.department_id group by  department_id",nativeQuery = true)
    Optional<List<Object[]>>getSumSalaryInAllDepartment();
    @Query(value = "select d.department_id,d.department_name,avrage(e.salary) from company_db.compony_department d ,company_db.employee_data e where d.department_id = e.department_id group by  department_id",nativeQuery = true)
    Optional<List<Object[]>>getAvarageSalaryInAllDepartment();
    @Query(value = " select d.department_id,d.department_name,sum(e.salary) from company_db.compony_department d,company_db.employee_data e where d.department_id=e.department_id and d.department_id=:department_id limit 1",nativeQuery = true)
    Optional<List<Object[]>>getEmployeeSalaryEachDepartment(@Param(value = "department_id")Long department_id );
    @Query(value = "select e.employee_id,count(p.child_d) from company_db.insurance_policy_for_employee p,company_db.employee_data e where e.employee_id=p.employee_id  group by (employee_id)",nativeQuery = true)
    Optional<List<Object[]>>getChildForAllEmployee();
    @Query(value = "select e.employee_id,count(p.child_d) from company_db.insurance_policy_for_employee p,company_db.employee_data e where e.employee_id=p.employee_id  and e.employee_id=:department_id limit 1",nativeQuery = true)
    Optional<List<Object[]>>getChildForEachEmployee(@Param(value = "department_id") Long department_id );
    @Query(value = "select e.employee_id,e.first_name,e.last_name,d.department_id,d.department_name from company_db.employee_data e,company_db.compony_department d,company_db.employee_job j where j.job_name = 'department manager'  and  e.department_id =d.department_id and e.job_id=j.job_id",nativeQuery = true)
    Optional<List<Object[]>>getAllManagerInAllDepartment();
    @Query(value = "select e.employee_id,e.first_name,e.last_name,d.department_id,d.department_name from company_db.employee_data e,company_db.compony_department d,company_db.employee_job j where j.job_name='department manager'  and  e.department_id =d.department_id and e.job_id=j.job_id and d.department_name = :department_name",nativeQuery = true)
    Optional<List<Object[]>>getManagerForEachDepartment(@Param(value = "department_name")String department_name);
    @Query(value = " select e.employee_id,e.first_name,e.last_name,d.department_id,d.department_name,e.salary from company_db.employee_data e,company_db.compony_department d,company_db.employee_job j where j.job_name='department manager' and  e.department_id =d.department_id and e.job_id=j.job_id group by(department_id)  ",nativeQuery = true)
    Optional<List<Object[]>>getManagerSalaryOfAllDepartment();

    EmployeeData findByFirstName(String firstName);

}