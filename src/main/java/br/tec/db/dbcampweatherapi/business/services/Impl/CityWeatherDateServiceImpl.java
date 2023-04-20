package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.business.services.CityWeatherDateService;
import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDate;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateDTO;
import br.tec.db.dbcampweatherapi.data.repository.CityWeatherDateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityWeatherDateServiceImpl implements CityWeatherDateService {

    CityWeatherDateRepository cityWeatherDateRepository;
    ModelMapper modelMapper;

    @Autowired
    public CityWeatherDateServiceImpl(CityWeatherDateRepository cityWeatherDateRepository, ModelMapper modelMapper) {
        this.cityWeatherDateRepository = cityWeatherDateRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CityWeatherDateDTO> findAll() {

        List<CityWeatherDate> allWeatherDateList = cityWeatherDateRepository.findAll();

        List<CityWeatherDateDTO> allWeatherListDTO = allWeatherDateList.stream()
                .map(allWeatherList -> modelMapper.map(allWeatherList, CityWeatherDateDTO.class))
                .collect(Collectors.toList());

        return allWeatherListDTO;
    }


    public CityWeatherDateDTO save(CityWeatherDateDTO cityWeatherDateDTO) {

        CityWeatherDate cityWeatherDate = modelMapper.map(cityWeatherDateDTO, CityWeatherDate.class);

        CityWeatherDate saved = cityWeatherDateRepository.save(cityWeatherDate);

        CityWeatherDateDTO weatherSavedDTO = modelMapper.map(saved, CityWeatherDateDTO.class);

        return weatherSavedDTO;
    }
}