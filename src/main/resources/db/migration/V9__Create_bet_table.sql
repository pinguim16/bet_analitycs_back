CREATE TABLE bet
(
    id SERIAL PRIMARY KEY,
    date             TIMESTAMP NOT NULL,
    competition_id   BIGINT    NOT NULL,
    category_id      BIGINT    NOT NULL,
    bookmaker_id     BIGINT    NOT NULL,
    bookmaker_bet_id VARCHAR(255) UNIQUE,
    state            VARCHAR(50),
    bet_type_id      BIGINT    NOT NULL,
    label            VARCHAR(255),
    odds             DOUBLE PRECISION,
    stake            DOUBLE PRECISION,
    tipster_id       BIGINT    NOT NULL,
    sport_id         BIGINT    NOT NULL,
    profit           DOUBLE PRECISION,
    total_value      DOUBLE PRECISION,
    closing          DOUBLE PRECISION,
    commission       DOUBLE PRECISION,
    live             BOOLEAN,
    freebet          BOOLEAN,
    cashout          BOOLEAN,
    each_way         BOOLEAN,
    comment          TEXT,
    CONSTRAINT fk_competition FOREIGN KEY (competition_id) REFERENCES competition (id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT fk_bookmaker FOREIGN KEY (bookmaker_id) REFERENCES bookmaker (id),
    CONSTRAINT fk_bet_type FOREIGN KEY (bet_type_id) REFERENCES bet_type (id),
    CONSTRAINT fk_tipster FOREIGN KEY (tipster_id) REFERENCES tipster (id),
    CONSTRAINT fk_sport FOREIGN KEY (sport_id) REFERENCES sport (id)
);