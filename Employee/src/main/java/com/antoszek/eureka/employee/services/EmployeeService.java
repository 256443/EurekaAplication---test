package com.antoszek.eureka.employee.services;

import com.antoszek.eureka.employee.controllers.EmployeeController;
import com.antoszek.eureka.employee.model.Employee;
import com.antoszek.eureka.employee.repository.EmployeeRepository;
import com.google.inject.internal.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<Employee> employees = Lists.newArrayList(employeeIterable);
        return employees;
    }
    public Optional<Employee> findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee;
        }
        return null;
    }

    public Employee save(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }
}
