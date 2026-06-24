package com.example.EmployeeCustomerModule.service;

import com.example.EmployeeCustomerModule.dto.EmployeeDto;
import com.example.EmployeeCustomerModule.entity.Employee;
import com.example.EmployeeCustomerModule.repository.EmployeeRepository;
import com.example.EmployeeCustomerModule.util.EmployeeMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {
       private final EmployeeRepository employeeRepository;
        private final EmployeeMapper employeeMapper;

    public EmployeeServiceImp(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee entity = employeeMapper.toEntity(employeeDto); // DTO -> Entity
        Employee savedEntity = employeeRepository.save(entity);
        return employeeMapper.toDto(savedEntity);
    }

    @Override
    public EmployeeDto getEmployeeById(int id) {
        Employee existing=employeeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        EmployeeDto employeeDtos= employeeMapper.toDto(existing);
        return  employeeDtos;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }
    @Override
    public EmployeeDto updateEmployee(int id, EmployeeDto employeeDto) {
        Employee existing=employeeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setEmployee_code(employeeDto.getEmployee_code());
        existing.setDesignation(employeeDto.getDesignation());
        existing.setFull_name(employeeDto.getFull_name());
        existing.setDate_of_birth(employeeDto.getDate_of_birth());
        existing.setJoining_date(employeeDto.getJoining_date());
        existing.set_active(employeeDto.is_active());
        Employee updatedEntity=employeeRepository.save(existing);
        return employeeMapper.toDto(updatedEntity);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee existing=employeeRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        employeeRepository.deleteById(id);
    }
}
