package br.tec.db.dbcampweatherapi.data.repository;

import br.tec.db.dbcampweatherapi.data.entity.CityWeatherDateList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CityWeatherDateListRepository extends JpaRepository<CityWeatherDateList, UUID> {

}