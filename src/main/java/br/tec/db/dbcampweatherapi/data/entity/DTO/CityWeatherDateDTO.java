package br.tec.db.dbcampweatherapi.data.entity.DTO;

import br.tec.db.dbcampweatherapi.data.entity.enums.DaytimeEnum;
import br.tec.db.dbcampweatherapi.data.entity.enums.NighttimeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityWeatherDateDTO {

    private UUID weatherId;

    @NotBlank
    private CityDTO city;

    @NotBlank
    private LocalDate date;

    @NotBlank
    @Enumerated(EnumType.STRING)
    DaytimeEnum daytimeEnum;

    @NotBlank
    @Enumerated(EnumType.STRING)
    NighttimeEnum nighttimeEnum;

    @NotBlank
    private Integer maxDegrees;

    @NotBlank
    private Integer minDegrees;

    @NotBlank
    private Integer precipitation;

    @NotBlank
    private Integer humidity;

    @NotBlank
    private Integer windSpeed;
}
