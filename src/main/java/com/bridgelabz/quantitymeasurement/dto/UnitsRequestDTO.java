package com.bridgelabz.quantitymeasurement.dto;

import com.bridgelabz.quantitymeasurement.service.Unit;

import javax.validation.constraints.NotNull;

public class UnitsRequestDTO {
    public double firstUnit;
    @NotNull(message = "INVALID TYPE")
    public Unit firstUnitType;
    @NotNull
    public Unit secondUnitType;

    public UnitsRequestDTO(double firstUnit, Unit firstUnitType, Unit secondUnitType) {
        this.firstUnit = firstUnit;
        this.firstUnitType = firstUnitType;
        this.secondUnitType = secondUnitType;
    }
}
