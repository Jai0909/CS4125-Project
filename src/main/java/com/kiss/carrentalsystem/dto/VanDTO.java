package com.kiss.carrentalsystem.dto;

public class VanDTO extends CarDTO{
    private int weight;

    public VanDTO() {
    }

    public VanDTO(String makeAndModel, String licencePlate, int milage, String vehicleType, boolean damaged, float basePrice, boolean availability, int weight) {
        super(makeAndModel, licencePlate, milage, vehicleType, damaged, basePrice, availability);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
