package com.api.gtasavehicles.dto;

import jakarta.persistence.Column;

import java.util.List;

public class VehicleView {
    private Long id;
    private String name;
    private String type;
    private List<String> images;
    public Long getId(){ return this.id; }
    public void setId(Long id){ this.id = id;}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }

    public VehicleView(Long id, String name, String type, List<String> images){
        setId(id);
        setName(name);
        setType(type);
        setImages(images);
    }
}
