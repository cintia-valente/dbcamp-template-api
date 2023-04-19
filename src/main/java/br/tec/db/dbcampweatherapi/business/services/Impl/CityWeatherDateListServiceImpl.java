package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.business.services.CityWeatherDateListService;
import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDateList;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateListDTO;
import br.tec.db.dbcampweatherapi.data.repository.CityWeatherDateListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityWeatherDateListServiceImpl implements CityWeatherDateListService {

    CityWeatherDateListRepository cityWeatherDateListRepository;
    ModelMapper modelMapper;

    @Autowired
    public CityWeatherDateListServiceImpl(CityWeatherDateListRepository cityWeatherDateListRepository, ModelMapper modelMapper) {
        this.cityWeatherDateListRepository = cityWeatherDateListRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CityWeatherDateListDTO> findAll() {

        List<CityWeatherDateList> allWeatherDateList = cityWeatherDateListRepository.findAll();

        List<CityWeatherDateListDTO> allWeatherListDTO = allWeatherDateList.stream()
                .map(allWeatherList -> modelMapper.map(allWeatherList, CityWeatherDateListDTO.class))
                .collect(Collectors.toList());

        return allWeatherListDTO;
    }


    public CityWeatherDateListDTO save(CityWeatherDateListDTO cityWeatherDateListDTO) {

        CityWeatherDateList cityWeatherDateList = modelMapper.map(cityWeatherDateListDTO, CityWeatherDateList.class);

        CityWeatherDateList saved = cityWeatherDateListRepository.save(cityWeatherDateList);

        CityWeatherDateListDTO weatherSavedDTO = modelMapper.map(saved, CityWeatherDateListDTO.class);

        return weatherSavedDTO;
    }
}