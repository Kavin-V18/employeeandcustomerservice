package com.example.EmployeeCustomerModule.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name="employee",schema = "public")
@Data
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String employee_code;
    @Column(nullable = false)
    private String full_name;
    @Column(nullable = false)
    private String designation;
    @Column( columnDefinition = "DATE CHECK (date_of_birth <= CURRENT_DATE - INTERVAL '18' YEAR)")
    private LocalDate date_of_birth;
    @Column( columnDefinition = "DATE CHECK (joining_date <= CURRENT_DATE)")
    private LocalDate joining_date;
    //image
//    @Lob
//    @Column(columnDefinition = "LONGBLOB")
    private byte[] profile_image;
    @ColumnDefault("true")
    private  boolean is_active;
     //foreign-key--mmanufacturing plant
     private Long manufacturingPlant;
     @CreationTimestamp
     private LocalDate created_at;
     @UpdateTimestamp
     private LocalDate last_modified_at;
     @CreatedBy
     private Long created_by;
     @LastModifiedBy
     private Long last_modified_by;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
}
