package com.example.EmployeeCustomerModule.repository;

import com.example.EmployeeCustomerModule.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
