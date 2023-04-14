package br.tec.db.dbcampweatherapi.business.services.Impl;

import br.tec.db.dbcampweatherapi.business.services.CityService;
import br.tec.db.dbcampweatherapi.data.entity.City;
import br.tec.db.dbcampweatherapi.data.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> findAllNameByStateIgnoreCase(String state) {
        return cityRepository.findAllNameByStateIgnoreCase(state);
    }
}
