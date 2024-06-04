package com.api.gtasavehicles.service;

import com.api.gtasavehicles.dto.VehicleDto;
import com.api.gtasavehicles.dto.VehicleParams;
import com.api.gtasavehicles.entity.Vehicle;
import com.api.gtasavehicles.repository.VehicleRepository;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobHttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    private Environment env;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle create(VehicleDto vehicle) {
        List<String> imageUrls = new ArrayList<>();

        List<MultipartFile> images = vehicle.getImages();
        try{
            for (MultipartFile file : images){
                imageUrls.add(uploadFile(file));
            }
        }catch (Exception e){
            throw e;
        }
        Vehicle vehicleCreated = new Vehicle(
                vehicle.getName(),
                vehicle.getType(),
                imageUrls);
        return vehicleRepository.save(vehicleCreated);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
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
    public String delete(Long id) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findById(id);
        if(vehicle.isEmpty()){
            return "There is no vehicle with ID " +id+ "\n";
        };
        try{
            this.vehicleRepository.deleteById(id);
            for (String img : vehicle.get().getImages()){
                if(!this.deleteFile(img)){
                    return "An error occurred while deleting main image " + img + "\n";
                };
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return "Deleted successfully";
    }
    /**
     * Faz o upload de um arquivo para o Azure Blob Storage.
     * Retorna a url do arquivo no Azure
     */
    @Override
    public String uploadFile(MultipartFile file) {
        String token        = env.getProperty("azure_blob_token");
        String url          = env.getProperty("azure_blob_url");
        String container    = env.getProperty("azure_blob_container");

        String blobUrl = null;
        String blobName = file.getOriginalFilename();

        if (token != null && url != null && container != null) {
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .endpoint(url)
                    .sasToken(token)
                    .buildClient();

            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(container);
            BlobClient blobClient = containerClient.getBlobClient(blobName);

            try {

                blobClient.upload(file.getInputStream(), file.getSize(), true);
                blobClient.setHttpHeaders(new BlobHttpHeaders().setContentType(file.getContentType()));
                blobUrl = blobClient.getBlobUrl();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return blobUrl;
    }
    /**
     * Delete um blob do azure
     * Retorna verdadeiro se sucesso, se não, falso
     * */
    @Override
    public boolean deleteFile(String blobUrl) {
        String token = env.getProperty("azure_blob_token");
        String url = env.getProperty("azure_blob_url");
        String container = env.getProperty("azure_blob_container");

        boolean success = false;
            if (token != null && url != null && container != null) {
                BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                        .endpoint(url)
                        .sasToken(token)
                        .buildClient();

                BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(container);

                String[] splitUrl = blobUrl.split("/");//divide a url por '/'
                String blobName = splitUrl[splitUrl.length - 1];//obtem o nome do blob

                BlobClient blobClient = containerClient.getBlobClient(blobName);

                success = blobClient.deleteIfExists();
            }
        return success;
    }
}
