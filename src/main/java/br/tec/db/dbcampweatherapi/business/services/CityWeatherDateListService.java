package br.tec.db.dbcampweatherapi.business.services;

import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateListDTO;

import java.util.List;

public interface CityWeatherDateListService {

    List<CityWeatherDateListDTO> findAll();

    CityWeatherDateListDTO save(CityWeatherDateListDTO cityWeatherDateListDTO);
}