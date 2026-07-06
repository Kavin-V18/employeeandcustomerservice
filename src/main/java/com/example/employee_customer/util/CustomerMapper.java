package com.example.employee_customer.util;

import com.example.employee_customer.dto.CustomerDto;
import com.example.employee_customer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        if (customer == null) return null;

        return CustomerDto.builder().address(customer.getAddress()).
                customerName(customer.getCustomerName()).
                email(customer.getEmail()).
                contactNumber(customer.getContactNumber()).
                createdAt(customer.getCreatedAt()).
                createdBy(customer.getCreatedBy()).
                lastModifiedAt(customer.getLastModifiedAt()).
                lastModifiedBy(customer.getLastModifiedBy()).
                active(customer.isActive()).build();
    }

    public Customer toEntity(CustomerDto dto) {
        if (dto == null) return null;
        Customer customer = new Customer();
        customer.setCustomerName(dto.getCustomerName());
        customer.setAddress(dto.getAddress());
        customer.setEmail(dto.getEmail());
        customer.setContactNumber(dto.getContactNumber());
        customer.setActive(dto.isActive());
        return customer;
    }
}
