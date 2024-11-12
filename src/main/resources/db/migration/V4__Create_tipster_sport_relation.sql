CREATE TABLE tipster_sports
(
    tipster_id BIGINT NOT NULL,
    sport_id   BIGINT NOT NULL,
    PRIMARY KEY (tipster_id, sport_id),
    CONSTRAINT fk_tipster FOREIGN KEY (tipster_id) REFERENCES tipster (id) ON DELETE CASCADE,
    CONSTRAINT fk_sport FOREIGN KEY (sport_id) REFERENCES sport (id) ON DELETE CASCADE
);
