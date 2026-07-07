package com.example.employee_customer.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturingPlantDto {
    private String name;
    private String code;
    private String location;
    @Min(1)
    private Integer capacityPerDay;
    @ColumnDefault("true")
    private boolean active;
    @NotNull
    private LocalDate createdAt;
    @NotNull
    private Long createdBy;
    @NotNull
    private LocalDate lastModifiedAt;
    @NotNull
    private Long lastModifiedBy;
}
