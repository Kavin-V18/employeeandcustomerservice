package com.example.EmployeeCustomerModule.service;

import com.example.EmployeeCustomerModule.dto.CustomerDto;
import com.example.EmployeeCustomerModule.entity.Customer;
import com.example.EmployeeCustomerModule.repository.CustomerRepository;
import com.example.EmployeeCustomerModule.util.CustomerMapper;
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
        Customer existing=customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        CustomerDto supplierDtos= customerMapper.toDto(existing);
        return  supplierDtos;
    }
    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toDto).toList();
    }
    @Override
    public CustomerDto updateCustomer(int id, CustomerDto customerDto) {
        Customer existing=customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        existing.setEmail(customerDto.getEmail());
        existing.setContact_number(customerDto.getContact_number());
        existing.setCustomer_name(customerDto.getCustomer_name());
        existing.setAddress(customerDto.getAddress());
        existing.set_active(customerDto.is_active());
        Customer updatedEntity=customerRepository.save(existing);
        return  customerMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteCustomer(int id) {
        Customer existing=customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        customerRepository.deleteById(id);
        return "deleted successfully";
    }
}
