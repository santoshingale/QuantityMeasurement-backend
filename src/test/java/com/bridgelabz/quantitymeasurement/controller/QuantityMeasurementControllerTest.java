package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitsDTO;
import com.bridgelabz.quantitymeasurement.service.IUnitConvertor;
import com.bridgelabz.quantitymeasurement.service.Unit;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityMeasurementControllerTest {
    UnitsDTO unitsDTO;
    Gson gson;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IUnitConvertor unitConvertor;

    @BeforeEach
    public void setUp() throws Exception {
        unitsDTO = new UnitsDTO(0.0, Unit.FEET, Unit.FEET);
        gson = new Gson();
    }


    @Test
    public void givenUnitsDto_whenRequest_thenReturnStatus200() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsDTO)).thenReturn(0.0);
        String unitDtoGson = gson.toJson(unitsDTO);
        System.out.println(unitDtoGson);
        MvcResult mvcResult = this.mockMvc.perform(post("/unitcomparator").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void givenUnitsDto_whenRequestImproper_thenReturnStatus404() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsDTO)).thenReturn(0.0);
        String unitDtoGson = gson.toJson(unitsDTO);
        MvcResult mvcResult = this.mockMvc.perform(post("/").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(404, status);
    }

    @Test
    public void givenUnitsDto_whenWrongContentType_thenReturnStatus415() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsDTO)).thenReturn(0.0);
        String unitDtoGson = gson.toJson(unitsDTO);
        System.out.println(unitDtoGson);
        MvcResult mvcResult = this.mockMvc.perform(post("/unitcomparator").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_XML)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(415, status);
    }

    @Test
    public void givenUnitsDto_whenWongContent_thenReturnStatus400() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsDTO)).thenReturn(0.0);
        String unitDtoGson = unitsDTO.toString();
        System.out.println(unitDtoGson);
        MvcResult mvcResult = this.mockMvc.perform(post("/unitcomparator").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(400, status);
    }

    /*@Test
    public void givenUnitsDto_whenWongContent_thenReturnStatus() throws Exception {

        unitsDTO = new UnitsDTO(12, null, Unit.CM);
        String unitDtoGson = gson.toJson(unitsDTO);
        System.out.println(unitDtoGson);
        MvcResult mvcResult = this.mockMvc.perform(post("/unitcomparator").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }*/

}
