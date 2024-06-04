package com.api.gtasavehicles.controller;

import com.api.gtasavehicles.dto.VehicleDto;
import com.api.gtasavehicles.dto.VehicleView;
import com.api.gtasavehicles.entity.Vehicle;
import com.api.gtasavehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class vehicleController {

    @Autowired
    private VehicleService vehicleService;
    @GetMapping()
    @CrossOrigin()
    public ResponseEntity<List<VehicleView>> get() {
        List<Vehicle> vehicles = vehicleService.getAll();
        List<VehicleView> vehicleViews = new ArrayList<>();
        for (Vehicle v : vehicles){
            vehicleViews.add(new VehicleView(v.getId(),v.getName(), v.getType(), v.getImages()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicleViews);
    }

    @PostMapping()
    public ResponseEntity<VehicleView> create(
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("images") List<MultipartFile> images
            ){
        VehicleDto vehicleDto = new VehicleDto(name, type, images);
        Vehicle savedVehicle = vehicleService.create(vehicleDto);
        VehicleView savedVehicleView = new VehicleView(
                savedVehicle.getId(),
                savedVehicle.getName(),
                savedVehicle.getType(),
                savedVehicle.getImages());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicleView);
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.delete(id));
    }
}
