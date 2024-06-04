package com.api.gtasavehicles.dto;

import com.api.gtasavehicles.entity.Vehicle;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class VehicleDto {

    private Long id;
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    private String name;

    @NotBlank(message = "Type is mandatory")
    @Size(max = 50, message = "Type should not exceed 50 characters")
    private String type;

    @NotNull(message = "Images cannot be null")
    @NotBlank(message = "Images File is mandatory")
    private List<@Pattern(regexp = "image/(gif|jpeg)", message = "Only JPG or GIF images are allowed") MultipartFile> images;

    //get e set----------------------------------------------------------------------
    public Long getId()                         { return id; }
    public void setId(Long id)                  { this.id = id; }
    public String getName()                     { return name; }
    public void setName(String name)            { this.name = name; }
    public String getType()                     { return type; }
    public void setType(String type)            { this.type = type; }
    public List<MultipartFile> getImages(){ return this.images; }
    //-------------------------------------------------------------------------------
    public VehicleDto() { }

    public VehicleDto(String name, String type, List<MultipartFile> images) {
        this.name = name;
        this.type = type;
        this.images = images;
    }
}