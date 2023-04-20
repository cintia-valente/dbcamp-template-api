package br.tec.db.dbcampweatherapi.business.services;

import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateDTO;

import java.util.List;

public interface CityWeatherDateService {

    List<CityWeatherDateDTO> findAll();

    CityWeatherDateDTO save(CityWeatherDateDTO cityWeatherDateDTO);
}