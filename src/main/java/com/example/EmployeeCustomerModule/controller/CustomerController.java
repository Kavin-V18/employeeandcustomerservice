package com.example.EmployeeCustomerModule.controller;

import com.example.EmployeeCustomerModule.entity.Customer;
import com.example.EmployeeCustomerModule.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

       private final  CustomerService customerService;

       public CustomerController(CustomerService customerService){
           this.customerService=customerService;
       }
    @GetMapping()
    public List<Customer> getNotifications() {
        return customerService.getAllCustomers();
    }
    @PostMapping()
    public  Customer createNotification(@Valid  @RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @GetMapping("/{id}")
    public Customer getNotificationById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }
    @PostMapping("/{id}")
    public Customer updateNotification(@PathVariable int id,@Valid @RequestBody Customer customer){
        return  customerService.updateCustomer(id, customer);
    }
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}
