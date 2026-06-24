package com.example.EmployeeCustomerModule.util;

import com.example.EmployeeCustomerModule.dto.CustomerDto;
import com.example.EmployeeCustomerModule.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        if (customer == null) return null;

        return CustomerDto.builder().address(customer.getAddress()).
                customer_name(customer.getCustomer_name()).
                email(customer.getEmail()).
                contact_number(customer.getContact_number()).
                created_at(customer.getCreated_at()).
                created_by(customer.getCreated_by()).
                last_modified_at(customer.getLast_modified_at()).
                last_modified_by(customer.getLast_modified_by()).
                is_active(customer.is_active()).build();
    }

    public Customer toEntity(CustomerDto dto) {
        if (dto == null) return null;
        Customer customer = new Customer();
        customer.setCustomer_name(dto.getCustomer_name());
        customer.setAddress(dto.getAddress());
        customer.setEmail(dto.getEmail());
        customer.setContact_number(dto.getContact_number());
        customer.set_active(dto.is_active());
        return customer;
    }
}
