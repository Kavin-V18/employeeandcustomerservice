package com.example.EmployeeCustomerModule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "customer",schema = "public")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(nullable = false)
    private String customer_name;
    @NotNull
    @Column(nullable = false)
    private String contact_number;
    @Email(message = "Provide a Valid Email")
    @NotNull
    @Column(nullable = false)
    private String email;
    @NotNull
    @Column(nullable = false)
    private String address;
    @ColumnDefault("true")
    private boolean is_active;
}
