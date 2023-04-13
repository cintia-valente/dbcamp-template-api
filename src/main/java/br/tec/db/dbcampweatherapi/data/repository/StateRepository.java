package br.tec.db.dbcampweatherapi.data.repository;

import br.tec.db.dbcampweatherapi.data.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StateRepository extends JpaRepository<State, String> {

}
