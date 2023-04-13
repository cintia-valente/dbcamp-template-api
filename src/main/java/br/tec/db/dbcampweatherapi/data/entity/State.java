package br.tec.db.dbcampweatherapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "state")
@Entity
public class State {
    @Id
    @Column(name = "state")
    private String state;


    @JsonIgnore // TODO excluir anotação e retirar o campo no DTO (record)
    @OneToMany(mappedBy = "state",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<City> stateCities = new ArrayList<>();
}
