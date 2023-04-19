package br.tec.db.dbcampweatherapi.business.services;

import br.tec.db.dbcampweatherapi.data.entity.DTO.CityDTO;

import java.util.List;

public interface CityService {

    List<CityDTO> findAllNameByStateIgnoreCase(String state);
}
