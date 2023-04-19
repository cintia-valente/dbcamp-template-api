package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.business.services.StateService;
import br.tec.db.dbcampweatherapi.data.entity.DTO.StateDTO;
import br.tec.db.dbcampweatherapi.data.entity.State;
import br.tec.db.dbcampweatherapi.data.repository.StateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    StateRepository stateRepository;

    ModelMapper modelMapper;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository, ModelMapper modelMapper) {
        this.stateRepository = stateRepository;
        this.modelMapper = modelMapper;
    }

    public List<StateDTO> findAll() {

        List<State> stateList = stateRepository.findAll();

        List<StateDTO> stateListDTO = stateList.stream()
                .map(state -> modelMapper.map(state, StateDTO.class))
                .collect(Collectors.toList());

        return stateListDTO;
    }
}
