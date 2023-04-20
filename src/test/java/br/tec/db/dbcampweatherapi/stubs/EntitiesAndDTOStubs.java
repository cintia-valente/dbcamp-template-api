package br.tec.db.dbcampweatherapi.stubs;

import br.tec.db.dbcampweatherapi.data.entity.City;
import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDate;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityDTO;
import br.tec.db.dbcampweatherapi.data.entity.DTO.CityWeatherDateDTO;
import br.tec.db.dbcampweatherapi.data.entity.DTO.StateDTO;
import br.tec.db.dbcampweatherapi.data.entity.State;
import br.tec.db.dbcampweatherapi.data.entity.enums.DaytimeEnum;
import br.tec.db.dbcampweatherapi.data.entity.enums.NighttimeEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntitiesAndDTOStubs {

    public static City cityStub(){
        City createdCityStub = new City();
        createdCityStub.setCityId(9390L);
        createdCityStub.setName("Santos");
        createdCityStub.setState("SP");

        List<CityWeatherDate> cityWeatherDate = new ArrayList<>();
        CityWeatherDate createdCityWeatherDate = new CityWeatherDate();
        createdCityWeatherDate.setWeatherId(UUID.fromString("ff9e98bd-4290-495b-bd12-4b949ccd1b8f"));
        createdCityWeatherDate.setDate(LocalDate.of(2023,5,17));
        createdCityWeatherDate.setDaytimeEnum(Enum.valueOf(DaytimeEnum.class, "SOL"));
        createdCityWeatherDate.setNighttimeEnum(Enum.valueOf(NighttimeEnum.class, "LIMPA"));
        createdCityWeatherDate.setMaxDegrees(30);
        createdCityWeatherDate.setMinDegrees(24);
        createdCityWeatherDate.setPrecipitation(0);
        createdCityWeatherDate.setHumidity(35);
        createdCityWeatherDate.setWindSpeed(22);

        createdCityWeatherDate.setCity(createdCityStub);
        cityWeatherDate.add(createdCityWeatherDate);
        createdCityStub.setWeatherDateLists(cityWeatherDate);

        return createdCityStub;
    }

    public static List<City> cityListStub() {
        List<City> createdCityList = new ArrayList<>();
        createdCityList.add(cityStub());

        return createdCityList;
    }

    public static State stateStub(){
        State createdStateStub = new State();
        createdStateStub.setState("SP");
        createdStateStub.setStateCities(cityListStub());

        return createdStateStub;
    }

    public static List<State> stateListStub(){
        List<State> createdStateListStub = new ArrayList<>();
        createdStateListStub.add(stateStub());

        return createdStateListStub;
    }

    public static CityWeatherDate cityWeatherDateStub(){
        City createdCityStub = new City();
        createdCityStub.setCityId(9390L);
        createdCityStub.setName("Santos");
        createdCityStub.setState("SP");

        List<CityWeatherDate> cityWeatherDate = new ArrayList<>();
        CityWeatherDate createdCityWeatherDate = new CityWeatherDate();
        createdCityWeatherDate.setWeatherId(UUID.fromString("ff9e98bd-4290-495b-bd12-4b949ccd1b8f"));
        createdCityWeatherDate.setDate(LocalDate.of(2023,5,17));
        createdCityWeatherDate.setDaytimeEnum(Enum.valueOf(DaytimeEnum.class, "SOL"));
        createdCityWeatherDate.setNighttimeEnum(Enum.valueOf(NighttimeEnum.class, "LIMPA"));
        createdCityWeatherDate.setMaxDegrees(30);
        createdCityWeatherDate.setMinDegrees(24);
        createdCityWeatherDate.setPrecipitation(0);
        createdCityWeatherDate.setHumidity(35);
        createdCityWeatherDate.setWindSpeed(22);

        createdCityWeatherDate.setCity(createdCityStub);
        cityWeatherDate.add(createdCityWeatherDate);
        createdCityStub.setWeatherDateLists(cityWeatherDate);

        return createdCityWeatherDate;
    }

    public static List<CityWeatherDate> cityWeatherDateListStub(){
        List<CityWeatherDate> createdCityWeatherDateList = new ArrayList<>();
        createdCityWeatherDateList.add(cityWeatherDateStub());

        return createdCityWeatherDateList;
    }

    public static CityDTO cityDTOStub() {
        CityDTO createdCityDTOStub = new CityDTO();
        createdCityDTOStub.setCityId(9390L);
        createdCityDTOStub.setName("Santos");

        return createdCityDTOStub;
    }

    public static List<CityDTO> cityDTOListStub(){
        List<CityDTO> createdCityDTOList = new ArrayList<>();
        createdCityDTOList.add(cityDTOStub());

        return createdCityDTOList;
    }

    public static StateDTO stateDTOStub(){
        StateDTO createdStateDTOStub = new StateDTO();
        createdStateDTOStub.setState("SP");

        return createdStateDTOStub;
    }

    public static List<StateDTO> stateDTOListStub(){
        List<StateDTO> createdStateDTOList = new ArrayList<>();
        createdStateDTOList.add(stateDTOStub());

        return  createdStateDTOList;
    }

    public static CityWeatherDateDTO cityWeatherDateDTOStub(){
        CityDTO createdCityDTOStub = new CityDTO();
        createdCityDTOStub.setCityId(9390L);
        createdCityDTOStub.setName("Santos");

        CityWeatherDateDTO cityWeatherDateDTO = new CityWeatherDateDTO();
        cityWeatherDateDTO.setWeatherId(UUID.fromString("ff9e98bd-4290-495b-bd12-4b949ccd1b8f"));
        cityWeatherDateDTO.setCity(createdCityDTOStub);
        cityWeatherDateDTO.setDate(LocalDate.of(2023,5,17));
        cityWeatherDateDTO.setDaytimeEnum(Enum.valueOf(DaytimeEnum.class, "SOL"));
        cityWeatherDateDTO.setNighttimeEnum(Enum.valueOf(NighttimeEnum.class, "LIMPA"));
        cityWeatherDateDTO.setMaxDegrees(30);
        cityWeatherDateDTO.setMinDegrees(24);
        cityWeatherDateDTO.setPrecipitation(0);
        cityWeatherDateDTO.setHumidity(35);
        cityWeatherDateDTO.setWindSpeed(22);

        return cityWeatherDateDTO;
    }

    public static List<CityWeatherDateDTO> cityWeatherDateDTOListStub(){
        List<CityWeatherDateDTO> createdCityWeatherDateDTOList = new ArrayList<>();
        createdCityWeatherDateDTOList.add(cityWeatherDateDTOStub());

        return createdCityWeatherDateDTOList;
    }
}
