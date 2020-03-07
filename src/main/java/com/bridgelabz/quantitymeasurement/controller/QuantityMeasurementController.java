package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitsDTO;
import com.bridgelabz.quantitymeasurement.service.IUnitConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/unitcomparator")
@CrossOrigin(origins = "*")
public class QuantityMeasurementController {

    @Autowired
    IUnitConvertor unitConvertor;

    @PostMapping
    public ResponseEntity<Double> getUnitData(@Valid @RequestBody UnitsDTO unitsDTO) {
        double convertedUnit = unitConvertor.getConvertedUnit(unitsDTO);
        System.out.println(convertedUnit);
        return new ResponseEntity<Double>(convertedUnit, HttpStatus.OK);
    }
}
