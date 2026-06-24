package com.example.EmployeeCustomerModule.controller;

import com.example.EmployeeCustomerModule.dto.EmployeeDto;
import com.example.EmployeeCustomerModule.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping()
    public List<EmployeeDto> getEmployee() {
        return employeeService.getAllEmployee();
    }
    @PostMapping()
    public  EmployeeDto createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }
    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable int id,@Valid @RequestBody EmployeeDto employeeDto){
        return  employeeService.updateEmployee(id, employeeDto);
    }
    public String deleteEmployee(@PathVariable int id){
         employeeService.deleteEmployee(id);
         return "deleted successfully";
    }
}
