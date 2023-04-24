package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityWeatherDateServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static br.tec.db.dbcampweatherapi.stubs.EntitiesAndDTOStubs.cityWeatherDateDTOListStub;
import static br.tec.db.dbcampweatherapi.stubs.EntitiesAndDTOStubs.cityWeatherDateDTOStub;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Weather Controller Listing Tests")
class CityWeatherDateControllerTest {

    @Mock
    CityWeatherDateServiceImpl cityWeatherDateListServiceMock;

    @InjectMocks
    CityWeatherDateController controllerUnderTest;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
    }

    @Test
    void testFindAll() throws Exception {

        when(cityWeatherDateListServiceMock.findAll()).thenReturn(cityWeatherDateDTOListStub());

        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/weather/list-all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].city.cityId").value(cityWeatherDateDTOListStub().get(0).getCity().getCityId()))
                .andExpect(jsonPath("$[0].city.name").value(cityWeatherDateDTOListStub().get(0).getCity().getName()))
                .andExpect(jsonPath("$[0].maxDegrees").value(cityWeatherDateDTOListStub().get(0).getMaxDegrees()))
                .andExpect(jsonPath("$[0].minDegrees").value(cityWeatherDateDTOListStub().get(0).getMinDegrees()))
                .andExpect(jsonPath("$[0].precipitation").value(cityWeatherDateDTOListStub().get(0).getPrecipitation()));

        verify(cityWeatherDateListServiceMock).findAll();
    }

    @Test
    void testCreate() throws Exception {

        when(cityWeatherDateListServiceMock.save(any(CityWeatherDateDTO.class))).thenReturn(cityWeatherDateDTOStub());

        // when
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/weather/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"weatherId\": \"ff9e98bd-4290-495b-bd12-4b949ccd1b8f\",\n \"city\": {\n \"cityId\": 9390,\n \"name\": \"Santos\"\n },\n \"date\": \"2023-05-12\",\n \"maxDegrees\": 30.0,\n \"minDegrees\": 8.0,\n \"precipitation\": 0.0,\n \"humidity\": 33.0,\n \"windSpeed\": 10.0\n}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.weatherId").value(cityWeatherDateDTOStub().getWeatherId().toString()))
                .andExpect(jsonPath("$.city.cityId").value(cityWeatherDateDTOStub().getCity().getCityId()))
                .andExpect(jsonPath("$.city.name").value(cityWeatherDateDTOStub().getCity().getName()))
                .andExpect(jsonPath("$.maxDegrees").value(cityWeatherDateDTOStub().getMaxDegrees()))
                .andExpect(jsonPath("$.minDegrees").value(cityWeatherDateDTOListStub().get(0).getMinDegrees()))
                .andExpect(jsonPath("$.precipitation").value(cityWeatherDateDTOListStub().get(0).getPrecipitation()));

        verify(cityWeatherDateListServiceMock).save(any(CityWeatherDateDTO.class));
    }

}
