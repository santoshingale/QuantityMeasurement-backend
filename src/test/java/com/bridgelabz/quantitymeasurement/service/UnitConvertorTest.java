package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UnitConvertorTest {
    @Test
    void given12Inch_whenConvetTypeIsFeet_shouldReturn1() {
        UnitConvertor unitConvertor = new UnitConvertor();
        double convertedUnit = unitConvertor.getConvertedUnit(new UnitsDTO(12, Unit.INCH, Unit.FEET));
        Assert.assertEquals(1.0,convertedUnit,0);
    }
}
