CREATE TABLE unit
(
    id SERIAL PRIMARY KEY,
    unit_value DOUBLE PRECISION NOT NULL,
    value      DOUBLE PRECISION NOT NULL,
    tipster_id BIGINT NOT NULL,
    CONSTRAINT fk_tipster_unit FOREIGN KEY (tipster_id) REFERENCES tipster (id) ON DELETE CASCADE
);
