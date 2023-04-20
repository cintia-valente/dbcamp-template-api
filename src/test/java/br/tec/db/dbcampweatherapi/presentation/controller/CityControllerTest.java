package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityServiceImpl;
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

import static br.tec.db.dbcampweatherapi.stubs.EntitiesAndDTOStubs.cityDTOListStub;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(MockitoExtension.class)
@DisplayName("City Controller Listing Tests")
class CityControllerTest {

    MockMvc mockMvc;

    @Mock
    CityServiceImpl cityServiceMock;

    @InjectMocks
    private CityController classUnderTest;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(classUnderTest).build();
    }

    @Test
    @DisplayName("Should return a list with all cities by State")
    void testFindAllNameByStateIgnoreCase() throws Exception {
        String state = "SP";
        when(cityServiceMock.findAllNameByStateIgnoreCase(state)).thenReturn(cityDTOListStub());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/weather/city/{state}/all-cities", state)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$[0].name").value(cityDTOListStub().get(0).getName()));
    }
}
