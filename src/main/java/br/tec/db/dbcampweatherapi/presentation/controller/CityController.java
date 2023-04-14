package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather/city")
public class CityController {
    CityServiceImpl cityService;

    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{state}/all-cities")
    public List<City> findAllNameByStateIgnoreCase(@PathVariable String state) {

        return cityService.findAllNameByStateIgnoreCase(state);
    }

    @GetMapping("/all")
    public List<City> findAll() {

        return cityService.findAll();
    }
}
