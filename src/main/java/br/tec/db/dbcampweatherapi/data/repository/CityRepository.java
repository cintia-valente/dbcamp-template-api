package br.tec.db.dbcampweatherapi.data.repository;

import br.tec.db.dbcampweatherapi.data.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    List<City> findByState(String state);

    List<City> findAllCityByStateIgnoreCase(String state);
}
