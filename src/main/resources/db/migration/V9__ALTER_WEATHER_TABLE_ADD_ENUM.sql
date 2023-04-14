ALTER TABLE city_weather_date_list
    ALTER COLUMN daytime_enum TYPE daytime_enum
        USING daytime_enum::text::daytime_enum;

ALTER TABLE city_weather_date_list
    ALTER COLUMN nighttime_enum TYPE nighttime_enum
        USING nighttime_enum::text::nighttime_enum;