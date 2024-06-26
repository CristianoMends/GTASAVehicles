package com.api.gtasavehicles.repository;

import com.api.gtasavehicles.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Override
    List<Vehicle> findAll();
}
