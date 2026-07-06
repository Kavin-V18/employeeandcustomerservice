package com.example.employee_customer.service;

import com.example.employee_customer.dto.EmployeeDto;
import com.example.employee_customer.util.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeResponse getEmployeeById(int id);
    List<EmployeeDto>  getAllEmployee();
    EmployeeDto  updateEmployee(int id,EmployeeDto employeeDto);
    void deleteEmployee(int id);

    Boolean existById(int id);
}
