package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;
import com.bridgelabz.quantitymeasurement.exception.MeasurementException;

import java.util.List;

public interface IUnitConvertorService {
    double getConvertedUnit(UnitsRequestDTO unitsRequestDTO) throws MeasurementException;

    public List getUnitList(String unitType);

    public List<UnitType> getUnitTypeList() throws MeasurementException;
}
