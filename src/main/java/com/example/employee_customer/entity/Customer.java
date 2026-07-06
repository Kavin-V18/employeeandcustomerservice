package com.example.employee_customer.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
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
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.ACTIVE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,name="customer_name")
    private String customerName;
    @Column(nullable = false,name="contact_number")
    private String contactNumber;
    @Email(message = "Provide a Valid Email")
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @ColumnDefault("true")
    @Column(name="is_active")
    private boolean active;
    @CreatedBy
    @Column(name="created_by")
    private Long createdBy;
    @LastModifiedBy
    @Column(name="last_modified_by")
    private Long lastModifiedBy;
    @CreationTimestamp
    @Column(name="created_At")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name="last_modified_at")
    private LocalDateTime lastModifiedAt;
}
