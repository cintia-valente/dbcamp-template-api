package br.tec.db.dbcampweatherapi.presentation.controller;

import br.tec.db.dbcampweatherapi.business.services.Impl.StateServiceImpl;
import br.tec.db.dbcampweatherapi.data.entity.DTO.StateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather/states")
public class StateController {

    StateServiceImpl stateServiceImpl;

    @Autowired
    public StateController(StateServiceImpl stateServiceImpl) {
        this.stateServiceImpl = stateServiceImpl;
    }

    @GetMapping("/all")
    public  List<StateDTO> findAllState() {

        return stateServiceImpl.findAll();
    }
}
