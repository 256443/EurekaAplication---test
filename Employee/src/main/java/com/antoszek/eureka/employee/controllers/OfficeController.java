package com.antoszek.eureka.employee.controllers;

import com.antoszek.eureka.employee.model.Employee;
import com.antoszek.eureka.employee.model.Office;
import com.antoszek.eureka.employee.services.EmployeeService;
import com.antoszek.eureka.employee.services.OfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    private static final Logger log = LoggerFactory.getLogger(OfficeController.class);
    private final OfficeService officeService;
    private final EmployeeService employeeService;
    @Autowired
    public OfficeController(OfficeService officeService, EmployeeService employeeService) {
        this.officeService = officeService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/all_office")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Office> getOffice(){
        List<Office> offices = officeService.findAll();
        log.info("Retrice objects {},", offices);
        return offices;
    }


    @RequestMapping(value = "/add_office",method = RequestMethod.POST)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public String save(@RequestBody OfficeDto officeDto){
        Office savedOffice =  new Office();
        System.out.println("DTO officenumber: "+officeDto.getOffice_number());
        System.out.println("DTO position: " + officeDto.getPosition());
        System.out.println("DTO employee_ID :" + officeDto.getEmployee_id());
        savedOffice.setOfficeNumber(officeDto.getOffice_number());
        savedOffice.setPosition(officeDto.getPosition());


//        Optional<Employee> employee = employeeRepository.findById(officeDto.getEmployee_id());
        System.out.println("Office number: " + savedOffice.getOfficeNumber());
        System.out.println("Setposition: " + savedOffice.getPosition());
//        Optional<Employee> employee = employeeService.findById(officeDto.getEmployee_id());
        Employee employee = employeeService.findById(officeDto.getEmployee_id());
        savedOffice.setEmployee(employee);
//        savedOffice.getEmployee().setId(officeDto.getEmployee_id());
        System.out.println("Employee IDDDD: " + savedOffice.getEmployee().getId());

        officeService.save(savedOffice);
//        log.info("Add new office {}", "Id pracownika: "+savedOffice.getEmployee().getId());
        return "\"Add new office {}\", \"Id pracownika: \"+savedOffice.getEmployee().getId());";
    }
}
