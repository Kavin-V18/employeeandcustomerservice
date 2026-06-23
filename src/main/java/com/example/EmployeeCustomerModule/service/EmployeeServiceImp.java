package com.example.EmployeeCustomerModule.service;

import com.example.EmployeeCustomerModule.entity.Employee;
import com.example.EmployeeCustomerModule.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {
       private final EmployeeRepository employeeRepository;
         public EmployeeServiceImp(EmployeeRepository employeeRepository){
             this.employeeRepository=employeeRepository;
         }
           @Override
           public Employee createEmployee( Employee employee){
                    return employeeRepository.save(employee);
           }
           @Override
            public Employee getEmployeeById(int id){
                return employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Employee not found with id: " + id));
            }
            @Override
              public List<Employee> getAllEmployee(){
                    return  employeeRepository.findAll();
              }
              @Override
               public Employee updateEmployee(int id,Employee employee){
                Employee existing=employeeRepository.findById(id).orElseThrow(() ->
                        new EntityNotFoundException("Employee not found with id: " + id));;
                  existing.setFull_name(employee.getFull_name());
                  existing.setDesignation(employee.getDesignation());
                  existing.setDate_of_birth(employee.getDate_of_birth());
                  existing.setJoining_date(employee.getJoining_date());
                  existing.set_active(employee.is_active());
                  return employeeRepository.save(existing);
              }
              @Override
            public void  deleteEmployee(int id){
                   Employee existing=employeeRepository.findById(id).orElseThrow(() ->
                           new EntityNotFoundException("Employee not found with id: " + id));
                    employeeRepository.delete(existing);
            }
}
