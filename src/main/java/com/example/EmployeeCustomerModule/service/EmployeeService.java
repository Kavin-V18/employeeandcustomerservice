package com.example.EmployeeCustomerModule.service;

import com.example.EmployeeCustomerModule.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(int id);
    List<EmployeeDto>  getAllEmployee();
    EmployeeDto  updateEmployee(int id,EmployeeDto employeeDto);
    void deleteEmployee(int id);
}
