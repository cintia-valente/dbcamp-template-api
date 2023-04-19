package br.tec.db.dbcampweatherapi.data.entity.DTO;

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
public class CityWeatherDateListDTO {

    @Id
    private UUID weatherId;

    private CityDTO city;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    DaytimeEnum daytimeEnum;

    @Enumerated(EnumType.STRING)
    NighttimeEnum nighttimeEnum;

    private Integer maxDegrees;

    private Integer minDegrees;

    private Integer precipitation;

    private Integer humidity;

    private Integer WindSpeed;
}
