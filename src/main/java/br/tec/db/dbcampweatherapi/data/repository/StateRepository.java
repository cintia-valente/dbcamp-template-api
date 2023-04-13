package br.tec.db.dbcampweatherapi.data.repository;

import br.tec.db.dbcampweatherapi.data.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, String> {

}
