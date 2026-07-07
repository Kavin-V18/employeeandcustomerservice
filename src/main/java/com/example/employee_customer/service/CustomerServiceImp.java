package com.example.employee_customer.service;

import com.example.employee_customer.dto.CustomerDto;
import com.example.employee_customer.entity.Customer;
import com.example.employee_customer.repository.CustomerRepository;
import com.example.employee_customer.util.CustomerMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer entity = customerMapper.toEntity(customerDto); // DTO -> Entity
        Customer savedEntity = customerRepository.save(entity);
        return customerMapper.toDto(savedEntity);
    }
    @Override
    public CustomerDto getCustomerById(int id) {
        Customer existing=customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return customerMapper.toDto(existing);
    }
    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toDto).toList();
    }
    @Override
    public CustomerDto updateCustomer(int id, CustomerDto customerDto) {
        Customer existing=customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existing.setEmail(customerDto.getEmail());
        existing.setContactNumber(customerDto.getContactNumber());
        existing.setCustomerName(customerDto.getCustomerName());
        existing.setAddress(customerDto.getAddress());
        existing.setActive(customerDto.isActive());
        Customer updatedEntity=customerRepository.save(existing);
        return  customerMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteCustomer(int id) {
        customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        customerRepository.deleteById(id);
        return "deleted successfully";
    }
}
