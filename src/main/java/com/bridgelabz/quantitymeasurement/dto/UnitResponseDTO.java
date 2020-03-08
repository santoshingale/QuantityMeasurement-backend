package com.bridgelabz.quantitymeasurement.dto;

public class UnitResponseDTO {
    public double secondUnit;
    public String message;

    public UnitResponseDTO(double secondUnit, String message) {
        this.secondUnit = secondUnit;
        this.message = message;
    }
}
