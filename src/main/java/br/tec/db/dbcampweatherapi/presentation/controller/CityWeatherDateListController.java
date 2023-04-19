package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityWeatherDateListServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<CityWeatherDateListDTO> findAll(){

        return cityWeatherDateListService.findAll();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public CityWeatherDateListDTO create(@RequestBody CityWeatherDateListDTO cityWeatherDateListDTO){

        return cityWeatherDateListService.save(cityWeatherDateListDTO);
    }
}
