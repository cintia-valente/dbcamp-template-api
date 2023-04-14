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
@EqualsAndHashCode(of = {"cityId", "state"})
@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore // TODO excluir anotação e retirar o campo no DTO (record) ;
    @Column(name = "state")
    private String state;

    @JsonIgnore // TODO excluir anotação e retirar o campo no DTO (record) ;
    @OneToMany(mappedBy = "city",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<CityWeatherDateList> weatherDateLists = new ArrayList<>();
}
