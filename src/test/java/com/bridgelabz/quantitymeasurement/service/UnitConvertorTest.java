package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UnitConvertorTest {
    @MockBean
    UnitConvertorService unitConvertorService;

    @Test
    void given12Inch_whenConvetTypeIsFeet_shouldReturn1() {
        when(unitConvertorService.getConvertedUnit(any())).thenReturn(1.0);
        double convertedUnit = unitConvertorService.getConvertedUnit(new UnitsRequestDTO(12, Unit.INCH, Unit.FEET));
        Assert.assertEquals(1.0, convertedUnit, 0);
    }

    @Test
    void given32Celsius_whenConvetTypeIsFahrenheit_shouldReturn1() {
        when(unitConvertorService.getConvertedUnit(any())).thenReturn(89.6);
        double convertedUnit = unitConvertorService.getConvertedUnit(new UnitsRequestDTO(32, Unit.CELSIUS, Unit.FAHRENHEIT));
        Assert.assertEquals(89.6, convertedUnit, 0);
    }

    @Test
    void givenGetUnitList_whenListIsPresent_shouldReturnThatList() {
        List list = new ArrayList();
        list.add("LENGTH");
        when(unitConvertorService.getUnitTypeList()).thenReturn(list);
        List<UnitType> unitTypeList = unitConvertorService.getUnitTypeList();
        Assert.assertEquals(1, unitTypeList.size());
    }

    @Test
    void givenGetUnit_whenUnitIsPresent_shouldReturnUnitList() {
        List list = new ArrayList();
        list.add("FEET");
        when(unitConvertorService.getUnitList(any())).thenReturn(list);
        List<UnitType> unitTypeList = unitConvertorService.getUnitList("LENGTH");
        Assert.assertEquals(1, unitTypeList.size());
    }
}
