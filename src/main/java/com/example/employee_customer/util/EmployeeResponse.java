package com.example.employee_customer.util;

import com.example.employee_customer.dto.EmployeeDto;
import com.example.employee_customer.dto.ManufacturingPlantDto;
import lombok.Data;

@Data
public class EmployeeResponse {
    private EmployeeDto employee;
    private ManufacturingPlantDto manufacturingPlant;
}
