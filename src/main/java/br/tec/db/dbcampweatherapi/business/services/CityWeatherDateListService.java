package br.tec.db.dbcampweatherapi.business.services;

import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDateList;

import java.util.List;

public interface CityWeatherDateListService {

    List<CityWeatherDateList> findAll();
}