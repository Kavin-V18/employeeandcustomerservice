package com.example.employee_customer.client;

import com.example.employee_customer.dto.ManufacturingPlantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "PlantsCarModule",
        url = "http://localhost:8082")
public interface CarPlantClient {
    @GetMapping("/manufacturingplant/{id}")
    ResponseEntity<ManufacturingPlantDto> getManufacturingPlantById(@PathVariable("id") Long id);

    @GetMapping("/manufacturingplant/{id}/exists")
    ResponseEntity<Boolean> checkManufacturingPlantExists(@PathVariable("id") Long id);
}
