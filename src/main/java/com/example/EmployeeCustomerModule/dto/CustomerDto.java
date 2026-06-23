package com.example.EmployeeCustomerModule.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String customer_name;
    private String contact_number;
    private String email;
    private String address;
    private boolean is_active;
}
