package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.data.entity.DTO.StateDTO;
import br.tec.db.dbcampweatherapi.data.entity.State;
import br.tec.db.dbcampweatherapi.data.repository.StateRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static br.tec.db.dbcampweatherapi.stubs.EntitiesAndDTOStubs.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("State Listing Tests")
class StateServiceImplTest {
    @Mock
    StateRepository stateRepositoryMock;

    @Mock
    ModelMapper modelMapperMock;

    @InjectMocks
    StateServiceImpl classUnderTest;

    @Test
    @DisplayName("Should return a list with all States")
    void findAll() {
        when(stateRepositoryMock.findAll()).thenReturn(stateListStub());
        when(modelMapperMock.map(any(State.class), eq(StateDTO.class))).thenReturn(stateDTOStub());

        List<StateDTO> response = classUnderTest.findAll();

        assertNotNull(response);
        assertEquals(stateDTOListStub(), response);
        assertEquals(stateDTOListStub().get(0).getState(), response.get(0).getState());

        verify(stateRepositoryMock).findAll();
        verify(modelMapperMock).map(any(State.class), eq(StateDTO.class));
    }
}