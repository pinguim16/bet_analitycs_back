ALTER TABLE bet
    ADD COLUMN bankroll_id BIGINT;

ALTER TABLE bet
    ADD CONSTRAINT fk_bankroll
        FOREIGN KEY (bankroll_id)
            REFERENCES bankroll (id);
