package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UnitConvertorTest {
    @Test
    void given12Inch_whenConvetTypeIsFeet_shouldReturn1() {
        UnitConvertorService unitConvertor = new UnitConvertorService();
        double convertedUnit = unitConvertor.getConvertedUnit(new UnitsRequestDTO(12, Unit.INCH, Unit.FEET));
        Assert.assertEquals(1.0,convertedUnit,0);
    }
}
