package com.example.EmployeeCustomerModule.controller;

import com.example.EmployeeCustomerModule.entity.Employee;
import com.example.EmployeeCustomerModule.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping()
    public List<Employee> getNotifications() {
        return employeeService.getAllEmployee();
    }
    @PostMapping()
    public  Employee createNotification(@RequestBody Employee notification){
        return employeeService.createEmployee(notification);
    }
    @GetMapping("/{id}")
    public Employee getNotificationById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/{id}")
    public Employee updateNotification(@PathVariable int id,@RequestBody Employee notification){
        return  employeeService.updateEmployee(id, notification);
    }
    public void deleteNotification(@PathVariable int id){
         employeeService.deleteEmployee(id);
    }
}
