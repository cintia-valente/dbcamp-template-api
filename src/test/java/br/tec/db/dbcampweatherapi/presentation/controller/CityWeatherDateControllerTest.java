package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityWeatherDateServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityDTO;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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
    @DisplayName("Should return a list with all weathers")
    void testFindAll() throws Exception {

        when(cityWeatherDateListServiceMock.findAll()).thenReturn(cityWeatherDateDTOListStub());

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
    @DisplayName("Should create and return the created weather")
    void testCreate() throws Exception {

        when(cityWeatherDateListServiceMock.save(any(CityWeatherDateDTO.class))).thenReturn(cityWeatherDateDTOStub());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        String valueMapped = mapper.writeValueAsString(cityWeatherDateDTOStub());

        System.out.println(valueMapped);

        String valueMappedWithDate = valueMapped.replace("[2023,5,17]", "\"2023-05-17\"");

        System.out.println(valueMappedWithDate);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/weather/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(valueMappedWithDate))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.weatherId").value(cityWeatherDateDTOStub().getWeatherId().toString()))
                .andExpect(jsonPath("$.city.cityId").value(cityWeatherDateDTOStub().getCity().getCityId()))
                .andExpect(jsonPath("$.city.name").value(cityWeatherDateDTOStub().getCity().getName()))
                .andExpect(jsonPath("$.maxDegrees").value(cityWeatherDateDTOStub().getMaxDegrees()))
                .andExpect(jsonPath("$.minDegrees").value(cityWeatherDateDTOStub().getMinDegrees()))
                .andExpect(jsonPath("$.precipitation").value(cityWeatherDateDTOStub().getPrecipitation()));

        verify(cityWeatherDateListServiceMock).save(any(CityWeatherDateDTO.class));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for empty value")
    void testCreateError() throws Exception {
        CityWeatherDateDTO emptyWeather = new CityWeatherDateDTO();
        emptyWeather.setCity(new CityDTO(null, null));

        assertThrows(IllegalArgumentException.class, ()-> controllerUnderTest.create(emptyWeather), "One or more required fields are null");

        verify(cityWeatherDateListServiceMock, never()).save(any(CityWeatherDateDTO.class));
    }
}
