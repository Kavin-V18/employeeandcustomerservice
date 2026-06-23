package com.example.EmployeeCustomerModule.service;

import com.example.EmployeeCustomerModule.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(int id, Customer notification);
    String deleteCustomer(int id);
}
