package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.data.entity.City;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityDTO;
import br.tec.db.dbcampweatherapi.data.repository.CityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static br.tec.db.dbcampweatherapi.stubs.EntitiesAndDTOStubs.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("City Listing Tests")
class CityServiceImplTest {

    @Mock
    CityRepository cityRepositoryMock;

    @Mock
    ModelMapper modelMapperMock;

    @InjectMocks
    CityServiceImpl serviceUnderTest;

    @Test
    @DisplayName("Should return a list with all cities by chosen state")
    void findAllNameByStateIgnoreCase() {

        when(cityRepositoryMock.findAllNameByStateIgnoreCase("SP")).thenReturn(cityListStub());
        when(modelMapperMock.map(any(City.class), eq(CityDTO.class))).thenReturn(cityDTOStub());

        List<CityDTO> response = serviceUnderTest.findAllNameByStateIgnoreCase("SP");

        assertNotNull(response);
        assertEquals(cityDTOListStub(), response);
        assertEquals(cityDTOListStub().get(0).getCityId(), response.get(0).getCityId());
        assertEquals(cityDTOListStub().get(0).getName(), response.get(0).getName());

        verify(cityRepositoryMock).findAllNameByStateIgnoreCase("SP");
        verify(modelMapperMock).map(any(City.class), eq(CityDTO.class));
    }
}