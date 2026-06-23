package com.example.EmployeeCustomerModule.entity;

import com.example.PlantsCarModule.entity.ManufacturingPlant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name="employee",schema = "public")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String employee_code;
    @NotNull
    @Column(nullable = false)
    private String full_name;
    @NotNull
    @Column(nullable = false)
    private String designation;
    @Column( columnDefinition = "DATE CHECK (date_of_birth <= CURRENT_DATE - INTERVAL '18' YEAR)")
    private LocalDate date_of_birth;
    @Column( columnDefinition = "DATE CHECK (joining_date <= CURRENT_DATE)")
    private LocalDate joining_date;
    //image
    @ColumnDefault("true")
    private  boolean is_active;
    //foreign key for plant
     //need to map
     private ManufacturingPlant manufacturingPlant;
}
