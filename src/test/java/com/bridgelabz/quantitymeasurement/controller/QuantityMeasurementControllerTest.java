package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.UnitsRequestDTO;
import com.bridgelabz.quantitymeasurement.exception.MeasurementException;
import com.bridgelabz.quantitymeasurement.service.IUnitConvertorService;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class QuantityMeasurementControllerTest {
    UnitsRequestDTO unitsRequestDTO;
    Gson gson;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IUnitConvertorService unitConvertor;

    @BeforeEach
    public void setUp() throws Exception {
        unitsRequestDTO = new UnitsRequestDTO(0.0, Unit.FEET, Unit.FEET);
        gson = new Gson();
    }


    @Test
    public void givenUnitsDto_whenRequest_thenReturnStatus200() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsRequestDTO)).thenReturn(0.0);
        String unitDtoGson = gson.toJson(unitsRequestDTO);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/converter").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String s = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);

    }

    @Test
    public void givenUnitsDto_whenRequestImproper_thenReturnStatus404() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsRequestDTO)).thenReturn(0.0);
        String unitDtoGson = gson.toJson(unitsRequestDTO);
        MvcResult mvcResult = this.mockMvc.perform(post("/").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(404, status);
    }

    @Test
    public void givenUnitsDto_whenWrongContentType_thenReturnStatus415() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsRequestDTO)).thenReturn(0.0);
        String unitDtoGson = gson.toJson(unitsRequestDTO);
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/converter").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_XML)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(415, status);
    }

    @Test
    public void givenUnitsDto_whenWongContent_thenReturnStatus400() throws Exception {
        when(unitConvertor.getConvertedUnit(unitsRequestDTO)).thenReturn(0.0);
        String unitDtoGson = unitsRequestDTO.toString();
        MvcResult mvcResult = this.mockMvc.perform(post("/unit/converter").content(unitDtoGson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(400, status);
    }

    @Test
    public void givenUnitsDto_whenWongContent_thenReturnException() throws Exception {
        try {
            unitsRequestDTO = new UnitsRequestDTO(0.0, Unit.FEET, Unit.LITRE);
            when(unitConvertor.getConvertedUnit(unitsRequestDTO)).thenThrow(new MeasurementException(MeasurementException.Type.TYPE_MISMATCH, "Type Mistch"));
            String unitDtoGson = unitsRequestDTO.toString();
            MvcResult mvcResult = this.mockMvc.perform(post("/unit/converter").content(unitDtoGson)
                    .contentType(MediaType.APPLICATION_JSON)).andReturn();
            int status = mvcResult.getResponse().getStatus();
        } catch (MeasurementException m) {
            Assert.assertEquals(MeasurementException.Type.TYPE_MISMATCH, m.type);
        }
    }

    @Test
    public void givenRequest_whenRequestIsGet_thenReturnArray() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/unit/converter")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
    }

    @Test
    public void givenRequestUnittype_whenRequestIsGet_thenReturnArray() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/unit/unittype")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
    }

    @Test
    public void givenRequest_whenRequestIsGetWithPathvariable_thenReturnArray() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/unit/LENGHT")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(200, status);
    }

    @Test
    public void givenRequest_whenRequestIsGetWithInvalidPathvariable_thenThrowException() throws Exception {
        when(unitConvertor.getUnitList(any())).thenThrow(new MeasurementException(MeasurementException
                .Type.TYPE_NOT_AVAILABLE, "Type Mistch"));
        String mvcResult = null;
        try {
            mvcResult = this.mockMvc.perform(get("/unit/LENGH")
                    .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        } catch (MeasurementException e) {
            Assert.assertEquals(MeasurementException.Type.TYPE_NOT_AVAILABLE, mvcResult);
        }
    }


}
