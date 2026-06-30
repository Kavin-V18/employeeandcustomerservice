package com.example.EmployeeCustomerModule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer",schema = "public")
@Data
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String customer_name;
    @Column(nullable = false)
    private String contact_number;
    @Email(message = "Provide a Valid Email")
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @ColumnDefault("true")
    private boolean is_active;
    @CreatedBy
    private Long created_by;
    @LastModifiedBy
    private Long last_modified_by;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
