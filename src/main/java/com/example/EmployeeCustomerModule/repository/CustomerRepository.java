package com.example.EmployeeCustomerModule.repository;

import com.example.EmployeeCustomerModule.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
