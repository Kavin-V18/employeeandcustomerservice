package com.example.EmployeeCustomerModule.dto;

import com.example.PlantsCarModule.entity.ManufacturingPlant;
import lombok.Data;
import java.time.LocalDate;
@Data
public class EmployeeDto {
    private String employee_code;
    private String full_name;
    private String designation;
    private LocalDate date_of_birth;
    private LocalDate joining_date;
    //image
    private  boolean is_active;
    //foreign key for plant
    private ManufacturingPlant manufacturingPlant;
}
