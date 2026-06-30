package com.example.EmployeeCustomerModule.controller;

import com.example.EmployeeCustomerModule.dto.CustomerDto;
import com.example.EmployeeCustomerModule.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

       private final  CustomerService customerService;
    @GetMapping()
    public List<CustomerDto> getCustomer() {
        return customerService.getAllCustomers();
    }
    @PostMapping()
    public  CustomerDto createCustomer(@Valid  @RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }
    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }
    @PostMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable int id,@Valid @RequestBody CustomerDto customerDto){
        return  customerService.updateCustomer(id, customerDto);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}
