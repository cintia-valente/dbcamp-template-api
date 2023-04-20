package br.tec.db.dbcampweatherapi.data.entity.DTO;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityDTO {

    private Long cityId;

    private String name;
}
