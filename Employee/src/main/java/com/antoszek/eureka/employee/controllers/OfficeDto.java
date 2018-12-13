package com.antoszek.eureka.employee.controllers;

public class OfficeDto {


    private int office_number;
    private String position;
    private Long employee_id;

    public int getOffice_number() {
        return office_number;
    }

    public void setOffice_number(int office_number) {
        this.office_number = office_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }
}
