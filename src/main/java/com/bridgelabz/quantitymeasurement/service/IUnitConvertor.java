package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsDTO;

public interface IUnitConvertor {
    public double getConvertedUnit(UnitsDTO unitsDTO);
}
