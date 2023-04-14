package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.business.services.CityWeatherDateListService;
import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDateList;
import br.tec.db.dbcampweatherapi.data.repository.CityWeatherDateListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityWeatherDateListServiceImpl implements CityWeatherDateListService {

    CityWeatherDateListRepository cityWeatherDateListRepository;

    @Autowired
    public CityWeatherDateListServiceImpl(CityWeatherDateListRepository cityWeatherDateListRepository) {
        this.cityWeatherDateListRepository = cityWeatherDateListRepository;
    }

    @Override
    public List<CityWeatherDateList> findAll() {
        return cityWeatherDateListRepository.findAll();
    }
}