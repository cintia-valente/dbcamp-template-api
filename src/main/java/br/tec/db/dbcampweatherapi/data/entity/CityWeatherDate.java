package br.tec.db.dbcampweatherapi.data.entity;

import br.tec.db.dbcampweatherapi.data.entity.enums.DaytimeEnum;
import br.tec.db.dbcampweatherapi.data.entity.enums.NighttimeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "city_weather_date_list")
public class CityWeatherDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID weatherId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "daytime_enum", nullable = false)
    DaytimeEnum daytimeEnum;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "nighttime_enum", nullable = false)
    NighttimeEnum nighttimeEnum;

    @NotNull
    @Column(name = "max_degrees", nullable = false)
    private Integer maxDegrees;

    @NotNull
    @Column(name = "min_degrees", nullable = false)
    private Integer minDegrees;

    @NotNull
    @Column(name = "precipitation", nullable = false)
    private Integer precipitation;

    @NotNull
    @Column(name = "humidity", nullable = false)
    private Integer humidity;

    @NotNull
    @Column(name = "wind_speed", nullable = false)
    private Integer windSpeed;

}
