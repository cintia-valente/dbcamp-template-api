package br.tec.db.dbcampweatherapi.stubs;

import br.tec.db.dbcampweatherapi.data.entity.City;
import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDateList;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityDTO;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateListDTO;
import br.tec.db.dbcampweatherapi.data.entity.DTO.StateDTO;
import br.tec.db.dbcampweatherapi.data.entity.State;
import br.tec.db.dbcampweatherapi.data.entity.enums.DaytimeEnum;
import br.tec.db.dbcampweatherapi.data.entity.enums.NighttimeEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntitiesAndDTOStubs {

    public static State stateStub(){
        List<City> cityList = new ArrayList<>();
        cityList.add(cityStub());

        State createdStateStub = new State();
        createdStateStub.setState("SP");
        createdStateStub.setStateCities(cityList);
        return createdStateStub;
    }

    public static City cityStub(){
        List<CityWeatherDateList> cityWeatherDateList = new ArrayList<>();
        cityWeatherDateList.add(cityWeatherDateListStub());

        City createdCityStub = new City();
        createdCityStub.setCityId(9390L);
        createdCityStub.setName("Santos");
        createdCityStub.setState(stateStub().getState());
        createdCityStub.setWeatherDateLists(cityWeatherDateList);

        return createdCityStub;
    }

    public static CityWeatherDateList cityWeatherDateListStub(){
        CityWeatherDateList createdCityWeatherDate = new CityWeatherDateList();
        createdCityWeatherDate.setWeatherId(UUID.fromString("ff9e98bd-4290-495b-bd12-4b949ccd1b8f"));
        createdCityWeatherDate.setCity(cityStub());
        createdCityWeatherDate.setDate(LocalDate.of(2023,5,17));
        createdCityWeatherDate.setDaytimeEnum(Enum.valueOf(DaytimeEnum.class, "SOL"));
        createdCityWeatherDate.setNighttimeEnum(Enum.valueOf(NighttimeEnum.class, "LIMPA"));
        createdCityWeatherDate.setMaxDegrees(30);
        createdCityWeatherDate.setMinDegrees(24);
        createdCityWeatherDate.setPrecipitation(0);
        createdCityWeatherDate.setHumidity(35);
        createdCityWeatherDate.setWindSpeed(22);

        return createdCityWeatherDate;
    }

    public static StateDTO stateDTOStub(){
        StateDTO createdStateDTOStub = new StateDTO();
        createdStateDTOStub.setState("SP");

        return createdStateDTOStub;
    }

    public static CityDTO cityDTOStub() {
        CityDTO createdCityDTOStub = new CityDTO();
        createdCityDTOStub.setCityId(9390L);
        createdCityDTOStub.setName("Santos");

        return createdCityDTOStub;
    }

    public static CityWeatherDateListDTO cityWeatherDateListDTOStub(){
        CityWeatherDateListDTO cityWeatherDateListDTO = new CityWeatherDateListDTO();
        cityWeatherDateListDTO.setWeatherId(UUID.fromString("ff9e98bd-4290-495b-bd12-4b949ccd1b8f"));
        cityWeatherDateListDTO.setCity(cityDTOStub());
        cityWeatherDateListDTO.setDate(LocalDate.of(2023,5,17));
        cityWeatherDateListDTO.setDaytimeEnum(Enum.valueOf(DaytimeEnum.class, "SOL"));
        cityWeatherDateListDTO.setNighttimeEnum(Enum.valueOf(NighttimeEnum.class, "LIMPA"));
        cityWeatherDateListDTO.setMaxDegrees(30);
        cityWeatherDateListDTO.setMinDegrees(24);
        cityWeatherDateListDTO.setPrecipitation(0);
        cityWeatherDateListDTO.setHumidity(35);
        cityWeatherDateListDTO.setWindSpeed(22);

        return cityWeatherDateListDTO;
    }
}
