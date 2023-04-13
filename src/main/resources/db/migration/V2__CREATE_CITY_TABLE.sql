CREATE TABLE IF NOT EXISTS city (
    city_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    state VARCHAR(2),
    FOREIGN KEY (state) REFERENCES state(state)
);