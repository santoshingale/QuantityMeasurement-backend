package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsDTO;
import org.springframework.stereotype.Service;

@Service
public class UnitConvertor implements IUnitConvertor {
    public double getConvertedUnit(UnitsDTO unitsDTO) {
        System.out.println(unitsDTO.secondUnitType);
        return  (unitsDTO.firstUnit * unitsDTO.firstUnitType.unitValue)/unitsDTO.secondUnitType.unitValue;
    }

}
