package com.api.gtasavehicles.service;

import com.api.gtasavehicles.dto.VehicleDto;
import com.api.gtasavehicles.dto.VehicleParams;
import com.api.gtasavehicles.entity.Vehicle;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface IVehicleService {
    public Vehicle create(VehicleDto vehicle);             //cria um veiculo
    public List<Vehicle> getAll();                            //obtem todos os veiculos
    public Vehicle getByParams(VehicleParams params);   //obtem por parametros
    public Vehicle update(VehicleParams vehicle);       //atualiza um veiculo
    public String delete(Long id);                     //deleta por id
    public String uploadFile(MultipartFile file);               //para upload de arquivo para o blob
    public boolean deleteFile(String url);              //deleta arquivo pela url
}
