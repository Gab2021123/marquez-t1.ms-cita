package com.marquez.application.client;

import com.marquez.application.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="marquez-t1.ms-doctor")
public interface DoctorClient {
    @GetMapping("/api/doctor/{id}")
    DoctorDTO obtenerDoctorId(@PathVariable Long id) ;
}
