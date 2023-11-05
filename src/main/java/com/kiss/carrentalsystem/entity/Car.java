package com.kiss.carrentalsystem.Entity;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
@Entity
@Table(name="car")
public class Car {
    @Id
    @Column(name="makeAndModel", length = 255)
    private String makeAndModel;
    @Column(name="lisencePlate", length = 255)
    private String lisencePlate;
    @Column(name="milage", length = 255)
    private int milage;
    @Column(name="vehicleType", length = 255)
    private String vehicleType;
    @Column(name="damaged", length = 255)
    private boolean damaged;
    @Column(name="basePrice", length = 255)
    private float basePrice;


    public Car() {
    }
}
