package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsDTO;
import com.bridgelabz.quantitymeasurement.exception.MesurementException;
import org.springframework.stereotype.Service;

@Service
public class UnitConvertor implements IUnitConvertor {
    public double getConvertedUnit(UnitsDTO unitsDTO) {
        if (unitsDTO.firstUnitType.unitType.equals(unitsDTO.secondUnitType.unitType)) {
            System.out.println(unitsDTO.secondUnitType);
            return (unitsDTO.firstUnit * unitsDTO.firstUnitType.unitValue) / unitsDTO.secondUnitType.unitValue;
        }
        throw new MesurementException(MesurementException.Type.TYPE_MISMATCH);
    }
}
