package com.example.EmployeeCustomerModule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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
    private String created_by;
    private String last_modified_by;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
}
