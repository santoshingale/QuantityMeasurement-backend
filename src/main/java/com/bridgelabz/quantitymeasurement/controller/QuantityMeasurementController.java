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
@RequestMapping("/unit")
@CrossOrigin(origins = "*")
public class QuantityMeasurementController {

    @Autowired
    IUnitConvertorService unitConvertorService;


    @PostMapping("/converter")
    public ResponseEntity<UnitResponseDTO> getUnitData(@Valid @RequestBody UnitsRequestDTO unitsRequestDTO) {
        double convertedUnit = unitConvertorService.getConvertedUnit(unitsRequestDTO);
        UnitResponseDTO unitResponseDTO = new UnitResponseDTO(convertedUnit,"Response Successful");
        return new ResponseEntity<UnitResponseDTO>(unitResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/unittype")
    public List<UnitType> getUnitType() {
        return unitConvertorService.getUnitTypeList();
    }
    
    @GetMapping("/{unittype}")
    public List getUnits(@PathVariable String unittype) {
        return unitConvertorService.getUnitList(unittype);
    }


}
