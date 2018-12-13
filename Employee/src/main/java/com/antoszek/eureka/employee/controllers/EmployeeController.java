package com.antoszek.eureka.employee.controllers;

import com.antoszek.eureka.employee.model.Employee;
import com.antoszek.eureka.employee.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/all_employees")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeService.findAll();
        log.info("Retrive objects {}", employees);
        return employees;
    }


    @RequestMapping(value = "/add_employee")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.save(employee);
        log.info("Add new employee {}", savedEmployee);
        return savedEmployee;
    }
}
