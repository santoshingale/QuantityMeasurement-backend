package com.bridgelabz.quantitymeasurement.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitListService {
    public List getUnitList(String unitType) {
        return Arrays.stream(Unit.values())
                .filter(unit -> unit.unitType.toString().equals(unitType))
                .collect(Collectors.toList());

    }
}
