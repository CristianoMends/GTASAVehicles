package com.api.gtasavehicles.entity;
import jakarta.persistence.*;


@Entity
class VehicleImage{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    // Getters and Setters

    public Long getId()                         { return id; }
    public void setId(Long id)                  { this.id = id; }
    public Vehicle getVehicle()                 { return vehicle; }
    public void setVehicle(Vehicle vehicle)     { this.vehicle = vehicle; }
    public String getImageUrl()                 { return imageUrl; }
    public void setImageUrl(String imageUrl)    { this.imageUrl = imageUrl; }

    public VehicleImage(Vehicle vehicle, String imageUrl) {
        this.vehicle = vehicle;
        this.imageUrl = imageUrl;
    }

    public VehicleImage() {
    }


}
