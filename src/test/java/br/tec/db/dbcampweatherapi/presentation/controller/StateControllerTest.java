package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.StateServiceImpl;
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

import static br.tec.db.dbcampweatherapi.stubs.EntitiesAndDTOStubs.stateDTOListStub;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("City Controller Listing Tests")
class StateControllerTest {

    MockMvc mockMvc;

    @Mock
    StateServiceImpl stateServiceMock;

    @InjectMocks
    StateController classUnderTest;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(classUnderTest).build();
    }

    @Test
    @DisplayName("Should return a lista with all States")
    void findAllState() throws Exception {

        when(stateServiceMock.findAll()).thenReturn(stateDTOListStub());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/weather/states/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].state").value(stateDTOListStub().get(0).getState()));
    }
}