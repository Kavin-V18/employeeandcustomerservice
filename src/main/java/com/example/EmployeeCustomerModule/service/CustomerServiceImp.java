package com.example.EmployeeCustomerModule.service;

import com.example.EmployeeCustomerModule.entity.Customer;
import com.example.EmployeeCustomerModule.entity.Employee;
import com.example.EmployeeCustomerModule.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerServiceImp(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    @Override
    public Customer getCustomerById(int id){
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Employee not found with id: " + id));
    }
    @Override
    public List<Customer> getAllCustomers(){
        return  customerRepository.findAll();
    }
    @Override
    public Customer updateCustomer(int id,Customer customer){
        Customer existing=customerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Employee not found with id: " + id));
        existing.setCustomer_name(customer.getCustomer_name());
        existing.setEmail(customer.getEmail());
        existing.setContact_number(customer.getContact_number());
        existing.setAddress(customer.getAddress());
        existing.set_active(customer.is_active());
        return customerRepository.save(existing);
    }
    @Override
    public String  deleteCustomer(int id){
        Customer existing=customerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Employee not found with id: " + id));
        customerRepository.delete(existing);
        return "deleted successfully";
    }
}
