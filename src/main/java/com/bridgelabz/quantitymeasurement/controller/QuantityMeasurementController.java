package com.bridgelabz.quantitymeasurement.controller;


import com.bridgelabz.quantitymeasurement.dto.UnitResponseDTO;
import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;
import com.bridgelabz.quantitymeasurement.service.IUnitConvertorService;
import com.bridgelabz.quantitymeasurement.service.UnitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/unitcomparator")
@CrossOrigin(origins = "*")
public class QuantityMeasurementController {

    @Autowired
    IUnitConvertorService unitConvertorService;


    @PostMapping
    public ResponseEntity<UnitResponseDTO> getUnitData(@Valid @RequestBody UnitsRequestDTO unitsRequestDTO) {
        double convertedUnit = unitConvertorService.getConvertedUnit(unitsRequestDTO);
        UnitResponseDTO unitResponseDTO = new UnitResponseDTO(convertedUnit,"Response Successful");
        return new ResponseEntity<UnitResponseDTO>(unitResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public List<UnitType> getUnitType() {
        System.out.println("in method right now");
        return unitConvertorService.getUnitTypeList();
    }
    
    @GetMapping("/{unit}")
    public List getUnits(@PathVariable String unit) {
        return unitConvertorService.getUnitList(unit);
    }


}
