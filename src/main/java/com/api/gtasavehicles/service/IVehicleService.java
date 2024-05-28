package com.api.gtasavehicles.service;

import com.api.gtasavehicles.dto.VehicleParams;
import com.api.gtasavehicles.entity.Vehicle;

import java.io.File;

public interface IVehicleService {
    public Vehicle create(Vehicle vehicle);             //cria um veiculo
    public Vehicle getAll();                            //obtem todos os veiculos
    public Vehicle getByParams(VehicleParams params);   //obtem por parametros
    public Vehicle update(VehicleParams vehicle);       //atualiza um veiculo
    public Vehicle delete(Long id);                     //deleta por id
    public Boolean uploadFile(File file);               //para upload de arquivo para o blob
    public Boolean deleteFile(String url);              //deleta arquivo pela url
}
