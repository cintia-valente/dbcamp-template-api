CREATE TABLE IF NOT EXISTS city_weather_date_list (
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