package com.example.EmployeeCustomerModule.service;

import com.example.EmployeeCustomerModule.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(int id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(int id, CustomerDto customerDto);
    String deleteCustomer(int id);
}
