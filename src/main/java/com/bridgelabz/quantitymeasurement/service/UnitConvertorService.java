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

        if (unitsRequestDTO.firstUnitType.unitType.equals(unitsRequestDTO.secondUnitType.unitType)
                && unitsRequestDTO.firstUnitType.unitType != UnitType.TEMPERATURE) {
            System.out.println(unitsRequestDTO.secondUnitType);
            return (unitsRequestDTO.firstUnit * unitsRequestDTO.firstUnitType.unitValue) / unitsRequestDTO.secondUnitType.unitValue;
        } else if ((unitsRequestDTO.firstUnitType.unitType.equals(unitsRequestDTO.secondUnitType.unitType)
                && unitsRequestDTO.firstUnitType.unitType == UnitType.TEMPERATURE)) {
            return this.getConverted(unitsRequestDTO);
        }
        throw new MeasurementException(MeasurementException.Type.TYPE_MISMATCH, "Type Mismatch");
    }

    private double getConverted(UnitsRequestDTO unitsRequestDTO) {
        if (unitsRequestDTO.firstUnitType == Unit.CELSIUS && unitsRequestDTO.secondUnitType == Unit.FAHRENHEIT) {
            return (unitsRequestDTO.firstUnit * unitsRequestDTO.firstUnitType.unitValue) + 32;
        } else if (unitsRequestDTO.firstUnitType == Unit.FAHRENHEIT && unitsRequestDTO.secondUnitType == Unit.CELSIUS) {
            return (unitsRequestDTO.firstUnit - 32) * unitsRequestDTO.firstUnitType.unitValue;
        }
        return unitsRequestDTO.firstUnit;
    }

    @Override
    public List getUnitList(String unitType) {
        List<Unit> collect = Arrays.stream(Unit.values())
                .filter(unit -> unit.unitType.toString().equals(unitType))
                .collect(Collectors.toList());
        if (collect.size() > 0) {
            return collect;
        }
        throw new MeasurementException(MeasurementException.Type.TYPE_NOT_AVAILABLE, "This type value does not exist");
    }

    @Override
    public List<UnitType> getUnitTypeList() {
        return Arrays.stream(UnitType.values())
                .collect(Collectors.toList());
    }
}
