package com.example.employee_customer.service;

import com.example.employee_customer.client.CarPlantClient;
import com.example.employee_customer.dto.EmployeeDto;
import com.example.employee_customer.dto.ManufacturingPlantDto;
import com.example.employee_customer.entity.Employee;
import com.example.employee_customer.repository.EmployeeRepository;
import com.example.employee_customer.util.EmployeeMapper;
import com.example.employee_customer.util.EmployeeResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
       private final EmployeeRepository employeeRepository;
        private final EmployeeMapper employeeMapper;
    private final CarPlantClient carPlantClient;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Boolean plantExists = carPlantClient.checkManufacturingPlantExists(employeeDto.getManufacturingPlant()).getBody();
        if (Boolean.FALSE.equals(plantExists)) {
            throw new EntityNotFoundException("Manufacturing Plant not found with id : " + employeeDto.getManufacturingPlant());
        }
        Employee entity = employeeMapper.toEntity(employeeDto);
        Employee savedEntity = employeeRepository.save(entity);
        return employeeMapper.toDto(savedEntity);
    }
    @Override
    public EmployeeResponse getEmployeeById(int id) {
        Employee existing=employeeRepository.findById(id).orElseThrow( EntityNotFoundException::new);
        ManufacturingPlantDto plant = carPlantClient.getManufacturingPlantById(existing.getManufacturingPlant()).getBody();
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployee(employeeMapper.toDto(existing));
        response.setManufacturingPlant(plant);
          return response;
    }
    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }
    @Override
    public EmployeeDto updateEmployee(int id, EmployeeDto employeeDto) {
        Boolean plantExists = carPlantClient.checkManufacturingPlantExists(employeeDto.getManufacturingPlant()).getBody();
        if (Boolean.FALSE.equals(plantExists)) {
            throw new EntityNotFoundException("Plant not found");
        }
        Employee existing=employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existing.setEmployeeCode(employeeDto.getEmployeeCode());
        existing.setDesignation(employeeDto.getDesignation());
        existing.setFullName(employeeDto.getFullName());
        existing.setDateOfBirth(employeeDto.getDateOfBirth());
        existing.setJoiningDate(employeeDto.getJoiningDate());
        existing.setActive(employeeDto.isActive());
        existing.setManufacturingPlant(employeeDto.getManufacturingPlant());
        Employee updatedEntity=employeeRepository.save(existing);
        return employeeMapper.toDto(updatedEntity);
    }
    @Override
    public void deleteEmployee(int id) {
       employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        employeeRepository.deleteById(id);
    }
    @Override
    public Boolean existById(int id) {
        return employeeRepository.existsById(id);
    }
}
