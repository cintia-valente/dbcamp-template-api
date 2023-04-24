package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityWeatherDateServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather")
public class CityWeatherDateController {

    CityWeatherDateServiceImpl cityWeatherDateListService;

    @Autowired
    public CityWeatherDateController(CityWeatherDateServiceImpl cityWeatherDateListService) {
        this.cityWeatherDateListService = cityWeatherDateListService;
    }

    @GetMapping("/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<CityWeatherDateDTO> findAll(){

        return cityWeatherDateListService.findAll();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public CityWeatherDateDTO create(@RequestBody @Validated CityWeatherDateDTO cityWeatherDateDTO){

        return cityWeatherDateListService.save(cityWeatherDateDTO);
    }
}
