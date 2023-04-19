package br.tec.db.dbcampweatherapi.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class State {
    @Id
    @Column(name = "state")
    private String state;


    @OneToMany(mappedBy = "state",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<City> stateCities = new ArrayList<>();
}
