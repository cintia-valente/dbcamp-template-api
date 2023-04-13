package br.tec.db.dbcampweatherapi.business.services;

import br.tec.db.dbcampweatherapi.data.entity.State;

import java.util.List;

public interface StateService {
    List<State> findAll();
}
