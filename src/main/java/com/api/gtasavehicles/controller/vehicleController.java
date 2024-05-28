package com.api.gtasavehicles.controller;

import com.api.gtasavehicles.dto.VehicleDto;
import com.api.gtasavehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController()
public class vehicleController {

    @Autowired
    private VehicleService vehicleService;
    @GetMapping()
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return null;
    }
}
