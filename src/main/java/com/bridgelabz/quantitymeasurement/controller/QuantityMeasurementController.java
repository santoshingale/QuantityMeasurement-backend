package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitsDTO;
import com.bridgelabz.quantitymeasurement.service.IUnitConvertor;
import com.bridgelabz.quantitymeasurement.service.Unit;
import com.bridgelabz.quantitymeasurement.service.UnitListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/unitcomparator")
@CrossOrigin(origins = "*")
public class QuantityMeasurementController {

    @Autowired
    IUnitConvertor unitConvertor;

    @Autowired
    UnitListService unitListService;

    @PostMapping
    public ResponseEntity<Double> getUnitData(@Valid @RequestBody UnitsDTO unitsDTO) {
        double convertedUnit = unitConvertor.getConvertedUnit(unitsDTO);
        System.out.println(convertedUnit);
        return new ResponseEntity<Double>(convertedUnit, HttpStatus.OK);
    }

    @GetMapping("/{unit}")
    public List getUnit(@PathVariable String unit) {
        return unitListService.getUnitList(unit);
    }
}
