CREATE TABLE tipster
(
    id SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    bingos   DOUBLE PRECISION NOT NULL,
    sport_id BIGINT       NOT NULL,
    CONSTRAINT fk_sport_tipster FOREIGN KEY (sport_id) REFERENCES sport (id) ON DELETE CASCADE
);
