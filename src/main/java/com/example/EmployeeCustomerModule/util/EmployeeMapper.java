package com.example.EmployeeCustomerModule.util;

import com.example.EmployeeCustomerModule.dto.EmployeeDto;
import com.example.EmployeeCustomerModule.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee employee) {
        if (employee == null) return null;

        return EmployeeDto.builder().full_name(employee.getFull_name()).
                designation(employee.getDesignation()).
                date_of_birth(employee.getDate_of_birth()).
                employee_code(employee.getEmployee_code()).
                joining_date(employee.getJoining_date()).
                employee_code(employee.getEmployee_code()).
                created_at(employee.getCreated_at()).
                created_by(employee.getCreated_by()).
                last_modified_at(employee.getLast_modified_at()).
                last_modified_by(employee.getLast_modified_by()).
                is_active(employee.is_active()).build();
    }
    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) return null;
        Employee employee = new Employee();
        employee.setEmployee_code(dto.getEmployee_code());
        employee.setFull_name(dto.getFull_name());
        employee.setDesignation(dto.getDesignation());
        employee.setDate_of_birth(dto.getDate_of_birth());
        employee.set_active(dto.is_active());
        employee.setJoining_date(dto.getJoining_date());
        employee.setEmployee_code(dto.getEmployee_code());
        return employee;
    }

}
