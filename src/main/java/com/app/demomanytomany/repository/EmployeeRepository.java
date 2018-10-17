package com.app.demomanytomany.repository;

import com.app.demomanytomany.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByEmployeeId(int employeeId);
}
