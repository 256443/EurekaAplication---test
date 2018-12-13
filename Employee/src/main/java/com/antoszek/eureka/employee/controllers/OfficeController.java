package com.antoszek.eureka.employee.controllers;

import com.antoszek.eureka.employee.model.Office;
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

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping("/all_office")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Office> getOffice(){
        List<Office> offices = officeService.findAll();
        log.info("Retrice objects {},", offices);
        return offices;
    }


    @RequestMapping("/add_office")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public String save(@RequestBody OfficeDto officeDto){
        Office savedOffice =  new Office();
        savedOffice.setOfficeNumber(officeDto.getOffice_number());
        savedOffice.setPosition(officeDto.getPosition());
        savedOffice.getEmployee().setId(officeDto.getEmployee_id());
        System.out.println("SPRAWDZAM SOBIE CZY UDALO MI SIE WYŁUSKAC EMPLOYEE_ID:   " + officeDto.getEmployee_id());
        officeService.save(savedOffice);
//        log.info("Add new office {}", "Id pracownika: "+savedOffice.getEmployee().getId());
        return "\"Add new office {}\", \"Id pracownika: \"+savedOffice.getEmployee().getId());";
    }
}
