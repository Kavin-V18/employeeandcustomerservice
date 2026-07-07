package com.example.employee_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeCustomerModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCustomerModuleApplication.class, args);
	}

}
