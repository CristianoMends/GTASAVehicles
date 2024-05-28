package com.api.gtasavehicles.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class VehicleDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name should not exceed 100 characters")
    private String name;

    @NotBlank(message = "Type is mandatory")
    @Size(max = 50, message = "Type should not exceed 50 characters")
    private String type;

    @NotBlank(message = "GIF URL is mandatory")
    private String gif;

    @NotNull(message = "Images list cannot be null")
    @NotEmpty(message = "Images list cannot be empty")
    private List<@NotBlank(message = "Image URL cannot be blank") String> images;

    //get e set----------------------------------------------------------------------
    public Long getId()                         { return id; }
    public void setId(Long id)                  { this.id = id; }
    public String getName()                     { return name; }
    public void setName(String name)            { this.name = name; }
    public String getType()                     { return type; }
    public void setType(String type)            { this.type = type; }
    public String getGif()                      { return gif; }
    public void setGif(String gif)              { this.gif = gif; }
    public List<String> getImages()             { return images; }
    public void setImages(List<String> images)  { this.images = images; }
    //-------------------------------------------------------------------------------
    public VehicleDto() {
    }

    public VehicleDto(Long id, String name, String type, String gif, List<String> images) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gif = gif;
        this.images = images;
    }
}