package com.antoszek.eureka.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue
    Long id;
    private String position;
    private int officeNumber;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Office() {
    }

    public Office(String position, int officeNumber) {
        this.position = position;
        this.officeNumber = officeNumber;
    }

    public Office(String position, int officeNumber, Employee employee) {
        this.position = position;
        this.officeNumber = officeNumber;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
