package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.CityServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather/city")
public class CityController {
    CityServiceImpl cityService;


    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{state}/all-cities")
    public List<CityDTO> findAllNameByStateIgnoreCase(@PathVariable String state) {

        return cityService.findAllNameByStateIgnoreCase(state);
    }

}
