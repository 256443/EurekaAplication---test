package com.antoszek.eureka.employee.services;

import com.antoszek.eureka.employee.controllers.OfficeDto;
import com.antoszek.eureka.employee.model.Employee;
import com.antoszek.eureka.employee.model.Office;
import com.antoszek.eureka.employee.repository.EmployeeRepository;
import com.antoszek.eureka.employee.repository.OfficeRepository;
import com.google.inject.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

//    @Autowired
//    private OfficeDto officeDto;

    @Autowired
    public OfficeService(OfficeRepository officeRepository, EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.officeRepository = officeRepository;
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    public List<Office> findAll() {
        Iterable<Office> officeIterable = officeRepository.findAll();
        List<Office> offices = Lists.newArrayList(officeIterable);
        return offices;
    }

//    public Employee save(Employee employee) {
//        Employee savedEmployee = employeeRepository.save(employee);
//        return savedEmployee;
//    }
    public Office save(Office office) {
        officeRepository.save(office);
        return office;
    }
}

//    Office office = new Office();
//        office.setOfficeNumber(officeDto.getOffice_number());
//                office.setPosition(officeDto.getPosition());
//                office.setEmployee(employee);
//                Office savedOffice = officeRepository.save(office);