package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityWeatherDateListServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDateList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather")
public class CityWeatherDateListController {

    CityWeatherDateListServiceImpl cityWeatherDateListService;

    @Autowired
    public CityWeatherDateListController(CityWeatherDateListServiceImpl cityWeatherDateListService) {
        this.cityWeatherDateListService = cityWeatherDateListService;
    }

    @GetMapping("/list-all")
    public List<CityWeatherDateList> findAll(){
        return cityWeatherDateListService.findAll();
    }
}
