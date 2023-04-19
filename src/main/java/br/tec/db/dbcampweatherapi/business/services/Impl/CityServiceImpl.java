package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.business.services.CityService;
import br.tec.db.dbcampweatherapi.data.entity.City;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityDTO;
import br.tec.db.dbcampweatherapi.data.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    CityRepository cityRepository;

    ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CityDTO> findAllNameByStateIgnoreCase(String state) {

        List<City> allCitiesByStateIgnoreCase = cityRepository.findAllNameByStateIgnoreCase(state);

        List<CityDTO> allCitiesByStateDTO = allCitiesByStateIgnoreCase.stream()
                .map(allCities -> modelMapper.map(allCities, CityDTO.class))
                .collect(Collectors.toList());

        return allCitiesByStateDTO;
    }
}
