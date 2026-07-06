package com.example.employee_customer.controller;

import com.example.employee_customer.dto.EmployeeDto;
import com.example.employee_customer.service.EmployeeService;
import com.example.employee_customer.util.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping()
    public List<EmployeeDto> getEmployee() {
        return employeeService.getAllEmployee();
    }
    @PostMapping()
    public  EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }
    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable int id,@Valid @RequestBody EmployeeDto employeeDto){
        return  employeeService.updateEmployee(id, employeeDto);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
         employeeService.deleteEmployee(id);
         return "deleted successfully";
    }
    @GetMapping("/{id}/exists")
    Boolean checkEmployeeExists(@PathVariable("id") int id){
        return employeeService.existById(id);
    }
}
