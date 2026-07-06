package com.example.employee_customer.util;

import com.example.employee_customer.dto.EmployeeDto;
import com.example.employee_customer.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee employee) {
        if (employee == null) return null;

        return EmployeeDto.builder().fullName(employee.getFullName()).
                designation(employee.getDesignation()).
                dateOfBirth(employee.getDateOfBirth()).
                employeeCode(employee.getEmployeeCode()).
                joiningDate(employee.getJoiningDate()).
                employeeCode(employee.getEmployeeCode()).
                createdAt(employee.getCreatedAt()).
                createdBy(employee.getCreatedBy()).
                manufacturingPlant(employee.getManufacturingPlant()).
                lastModifiedAt(employee.getLastModifiedAt()).
                lastModifiedBy(employee.getLastModifiedBy()).
                active(employee.isActive()).build();
    }
    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) return null;
        Employee employee = new Employee();
        employee.setEmployeeCode(dto.getEmployeeCode());
        employee.setFullName(dto.getFullName());
        employee.setDesignation(dto.getDesignation());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setActive(dto.isActive());
        employee.setJoiningDate(dto.getJoiningDate());
        employee.setManufacturingPlant(dto.getManufacturingPlant());
        return employee;
    }
}
