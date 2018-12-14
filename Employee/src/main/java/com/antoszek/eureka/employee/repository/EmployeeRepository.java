package com.antoszek.eureka.employee.repository;

import com.antoszek.eureka.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
