package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;

import java.util.List;

public interface IUnitConvertorService {
    public double getConvertedUnit(UnitsRequestDTO unitsRequestDTO);
    public List getUnitList(String unitType);
    public List<UnitType> getUnitTypeList();
    }
