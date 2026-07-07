package com.example.employee_customer.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDate;

@Entity
@Table(name="employee",schema = "public")
@Data
@EntityListeners(AuditingEntityListener.class)
@SoftDelete(strategy = SoftDeleteType.ACTIVE)
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column(name="employee_code")
    private String employeeCode;
    @Column(nullable = false,name="full_name")
    private String fullName;
    @Column(nullable = false)
    private String designation;
    @Column( columnDefinition = "DATE CHECK (date_of_birth <= CURRENT_DATE - INTERVAL '18' YEAR)",name="date_of_birth")
    private LocalDate dateOfBirth;
    @Column( columnDefinition = "DATE CHECK (joining_date <= CURRENT_DATE)",name="joining_date")
    private LocalDate joiningDate;
    //image
//    @Lob
//    @Column(columnDefinition = "LONGBLOB",name="profile_image")
    @Column(name="profile_image")
    private String profileImage;
    @ColumnDefault("true")
    @Column(name="is_active")
    private  boolean active;
     //foreign-key
     private Long manufacturingPlant;
     @CreationTimestamp
     @Column(name="created_at")
     private LocalDate createdAt;
     @UpdateTimestamp
     @Column(name="last_modified_at")
     private LocalDate lastModifiedAt;
     @CreatedBy
     @Column(name="created_by")
     private Long createdBy;
     @LastModifiedBy
     @Column(name="last_modified_by")
     private Long lastModifiedBy;
}
