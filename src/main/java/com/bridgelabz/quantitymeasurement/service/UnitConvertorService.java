package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;
import com.bridgelabz.quantitymeasurement.exception.MeasurementException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitConvertorService implements IUnitConvertorService {

    @Override
    public double getConvertedUnit(UnitsRequestDTO unitsRequestDTO) {
        if (unitsRequestDTO.firstUnitType.unitType.equals(unitsRequestDTO.secondUnitType.unitType)) {
            System.out.println(unitsRequestDTO.secondUnitType);
            return (unitsRequestDTO.firstUnit * unitsRequestDTO.firstUnitType.unitValue) / unitsRequestDTO.secondUnitType.unitValue;
        }
        throw new MeasurementException(MeasurementException.Type.TYPE_MISMATCH,"Type Mismatch");
    }

    @Override
    public List getUnitList(String unitType) {
        if(Unit.values().toString().contains(unitType))
            System.out.println("key contain");
        return Arrays.stream(Unit.values())
                .filter(unit -> unit.unitType.toString().equals(unitType))
                .collect(Collectors.toList());
    }

    @Override
    public List<UnitType> getUnitTypeList() {
        return Arrays.stream(UnitType.values())
                .collect(Collectors.toList());
    }
}
