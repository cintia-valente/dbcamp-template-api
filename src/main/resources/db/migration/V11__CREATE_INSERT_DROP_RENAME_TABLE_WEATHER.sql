CREATE TABLE city_weather_date_list_temp (
     weather_id UUID NOT NULL PRIMARY KEY,
     city_id BIGINT NOT NULL,
     date DATE NOT NULL,
     daytime_enum VARCHAR(40) NOT NULL,
     nighttime_enum VARCHAR(40) NOT NULL,
     max_degrees INTEGER NOT NULL,
     min_degrees INTEGER NOT NULL,
     precipitation INTEGER NOT NULL,
     humidity INTEGER NOT NULL,
     wind_speed INTEGER NOT NULL,
     FOREIGN KEY (city_id) REFERENCES city(city_id)
);

-- Copying the data from the original table to the temporary table
INSERT INTO city_weather_date_list_temp
SELECT * FROM city_weather_date_list;

-- Dropping the original table
DROP TABLE city_weather_date_list;

-- Renaming the temporary table with the original table name
ALTER TABLE city_weather_date_list_temp RENAME TO city_weather_date_list;