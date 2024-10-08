CREATE TABLE tipster
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    bingos   DOUBLE,
    sport_id BIGINT,
    CONSTRAINT fk_sport FOREIGN KEY (sport_id) REFERENCES sport (id)
);
