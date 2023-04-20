package br.tec.db.dbcampweatherapi.config.modelmapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ModelMapperConfigTest {

    @InjectMocks
    private ModelMapperConfig modelMapperConfig;

    @Test
    public void testMapper() {
        ModelMapper mapper = modelMapperConfig.mapper();
        assertNotNull(mapper);
    }
}
