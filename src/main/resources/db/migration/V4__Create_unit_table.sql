CREATE TABLE unit
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    unit_value DOUBLE,
    value      DOUBLE,
    tipster_id BIGINT,
    CONSTRAINT fk_tipster FOREIGN KEY (tipster_id) REFERENCES tipster (id)
);
