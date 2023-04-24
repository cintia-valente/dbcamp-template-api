package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDate;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateDTO;
import br.tec.db.dbcampweatherapi.data.repository.CityWeatherDateRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static br.tec.db.dbcampweatherapi.stubs.EntitiesAndDTOStubs.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Weather Listing Tests")
class CityWeatherDateServiceImplTest {

    @Mock
    CityWeatherDateRepository cityWeatherDateRepositoryMock;

    @Mock
    ModelMapper modelMapperMock;

    @InjectMocks
    CityWeatherDateServiceImpl serviceUnderTest;

    @Test
    @DisplayName("Should return a list with all Weathers")
    public void testFindAll() {

        when(cityWeatherDateRepositoryMock.findAll()).thenReturn(cityWeatherDateListStub());
        when(modelMapperMock.map(any(CityWeatherDate.class), eq(CityWeatherDateDTO.class))).thenReturn(cityWeatherDateDTOStub());

        List<CityWeatherDateDTO> result = serviceUnderTest.findAll();

        assertNotNull(result);
        assertEquals(cityWeatherDateDTOListStub(), result);
        assertEquals(cityWeatherDateDTOListStub().size(), result.size());
        assertEquals(cityWeatherDateDTOListStub().get(0).getWeatherId(), result.get(0).getWeatherId());
        assertEquals(cityWeatherDateDTOListStub().get(0).getCity(), result.get(0).getCity());
        assertEquals(cityWeatherDateDTOListStub().get(0).getDate(), result.get(0).getDate());

        verify(cityWeatherDateRepositoryMock).findAll();
        verify(modelMapperMock).map(any(CityWeatherDate.class), eq(CityWeatherDateDTO.class));
    }

    @Test
    @DisplayName("Should save a new weather register")
    public void testSave() {

        when(modelMapperMock.map(any(CityWeatherDateDTO.class), eq(CityWeatherDate.class))).thenReturn(cityWeatherDateStub());
        when(cityWeatherDateRepositoryMock.save(any(CityWeatherDate.class))).thenReturn(cityWeatherDateStub());
        when(modelMapperMock.map(any(CityWeatherDate.class), eq(CityWeatherDateDTO.class))).thenReturn(cityWeatherDateDTOStub());

        CityWeatherDateDTO result = serviceUnderTest.save(cityWeatherDateDTOStub());

        assertNotNull(result);
        assertEquals(cityWeatherDateDTOStub(), result);
        assertEquals(cityWeatherDateDTOStub().getWeatherId(), result.getWeatherId());
        assertEquals(cityWeatherDateDTOStub().getCity(), result.getCity());
        assertEquals(cityWeatherDateDTOStub().getDate(), result.getDate());

        verify(modelMapperMock).map(any(CityWeatherDateDTO.class), eq(CityWeatherDate.class));
        verify(modelMapperMock).map(any(CityWeatherDate.class), eq(CityWeatherDateDTO.class));
        verify(cityWeatherDateRepositoryMock).save(any(CityWeatherDate.class));
    }

}