package com.api.gtasavehicles.service;

import com.api.gtasavehicles.dto.VehicleParams;
import com.api.gtasavehicles.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class VehicleService implements IVehicleService{
    @Override
    public Vehicle create(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle getAll() {
        return null;
    }

    @Override
    public Vehicle getByParams(VehicleParams params) {
        return null;
    }

    @Override
    public Vehicle update(VehicleParams vehicle) {
        return null;
    }

    @Override
    public Vehicle delete(Long id) {
        return null;
    }

    @Override
    public Boolean uploadFile(File file) {
        //adicionar a logica para subir o arquivo no cloud
        return null;
    }

    @Override
    public Boolean deleteFile(String url) {
        //adicionar a logica para deletar o arquivo no cloud
        return null;
    }
}
