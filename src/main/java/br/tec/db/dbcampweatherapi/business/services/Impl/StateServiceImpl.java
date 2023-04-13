package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.business.services.StateService;
import br.tec.db.dbcampweatherapi.data.entity.State;
import br.tec.db.dbcampweatherapi.data.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StateServiceImpl implements StateService {

    StateRepository stateRepository;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> findAllState() {
        return stateRepository.findAll();
    }
}
