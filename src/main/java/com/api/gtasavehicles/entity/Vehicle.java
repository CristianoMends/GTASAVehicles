package com.api.gtasavehicles.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String type;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleImage> images;

    // Getters and Setters

    public Long getId()                                 { return id; }
    public void setId(Long id)                          { this.id = id; }
    public String getName()                             { return name; }
    public void setName(String name)                    { this.name = name; }
    public String getType()                             { return type; }
    public void setType(String type)                    { this.type = type; }
    public List<String> getImages()               {
        List<String> urls = new ArrayList<>();
        for (VehicleImage v : images){
            urls.add(v.getImageUrl());
        }
        return urls;
    }
    public void setImages(List<String> images) {
        this.images = new ArrayList<>();
        for (String image:images){
            this.images.add(new VehicleImage(this, image));
        }
    }

    public Vehicle(String name, String type, List<String> images) {
        this.name = name;
        this.type = type;
        setImages(images);
    }

    public Vehicle() {
    }
}
