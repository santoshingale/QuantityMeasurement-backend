package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        Assert.assertEquals(1.0,convertedUnit,0);
    }
}
