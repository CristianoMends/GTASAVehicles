package com.api.gtasavehicles.entity;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String gif;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleImage> images;

    // Getters and Setters

    public Long getId()                                 { return id; }
    public void setId(Long id)                          { this.id = id; }
    public String getName()                             { return name; }
    public void setName(String name)                    { this.name = name; }
    public String getType()                             { return type; }
    public void setType(String type)                    { this.type = type; }
    public String getGif()                              { return gif; }
    public void setGif(String gif)                      { this.gif = gif; }
    public List<VehicleImage> getImages()               { return images; }
    public void setImages(List<VehicleImage> images)    { this.images = images; }

    public Vehicle(Long id, String name, String type, String gif, List<VehicleImage> images) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gif = gif;
        this.images = images;
    }

    public Vehicle() {
    }
}
