package br.tec.db.dbcampweatherapi.data.entity;

import br.tec.db.dbcampweatherapi.data.entity.enums.DaytimeEnum;
import br.tec.db.dbcampweatherapi.data.entity.enums.NighttimeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "city_weather_date_list")
public class CityWeatherDateList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID weatherId;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "daytime_enum", nullable = false)
    DaytimeEnum daytimeEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "nighttime_enum", nullable = false)
    NighttimeEnum nighttimeEnum;


    @Column(name = "max_degrees", nullable = false)
    private Integer maxDegrees;

    @Column(name = "min_degrees", nullable = false)
    private Integer minDegrees;

    @Column(name = "precipitation", nullable = false)
    private Integer precipitation;

    @Column(name = "humidity", nullable = false)
    private Integer humidity;

    @Column(name = "wind_speed", nullable = false)
    private Integer WindSpeed;

}
